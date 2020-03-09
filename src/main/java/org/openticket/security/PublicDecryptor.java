package org.openticket.security;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.SignatureException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateFactory;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.X509Certificate;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;

import org.bouncycastle.util.io.pem.PemObject;
import org.bouncycastle.util.io.pem.PemReader;

import org.openticket.Legitimation;

public class PublicDecryptor {

	/**
	 * The public key raw bytes.
	 */
	private byte[] publicKey;

	/**
	 * Creates a new instance of PublicDecryptor class by loading a public key or a certificate in PEM format.
	 *
	 * @param publicFilename The public key or cert filename
	 */
	public PublicDecryptor(String publicFilename) {
		PemReader pemReader = null; 
		
		try {
			pemReader = new PemReader(new InputStreamReader(new FileInputStream(publicFilename)));
			PemObject pemObject = pemReader.readPemObject();
			
			if (pemObject.getType().endsWith(PemObjectType.CERTIFICATE)) {
				CertificateFactory certFactory = CertificateFactory.getInstance("X509");
				X509Certificate cert = (X509Certificate) certFactory.generateCertificate(new ByteArrayInputStream(pemObject.getContent()));
				
				cert.checkValidity();
				
				PublicKey publicKey = cert.getPublicKey();
				cert.verify(publicKey);
				
				this.publicKey = publicKey.getEncoded();
			} else if (pemObject.getType().endsWith(PemObjectType.PUBLIC_KEY)) {
				this.publicKey = pemObject.getContent();
			} else {
				throw new Exception();
			}
		} catch(CertificateNotYetValidException e) {
			throw new RuntimeException("public key certificate is not valid yet");
		} catch (CertificateExpiredException e) {
			throw new RuntimeException("public key certificate is expired");
		} catch (SignatureException e) {
			throw new RuntimeException("invalid certificate signature");
		} catch(Exception e) {
			throw new RuntimeException("cannot read " + publicFilename);
		} finally {
			try {
				pemReader.close();
			} catch (IOException e) {
			}
		}
	}

	/**
	 * Decrypts raw legitimation bytes to a Legitimation message.
	 *
	 * @param encryptedLegitimation The encrypted legitimation bytes
	 * @return A decrypted Legitimation message
	 * @throws RuntimeException When the decryption failed
	 */
	public Legitimation decryptLegitimation(byte[] encryptedLegitimation) throws RuntimeException {
		try {
			X509EncodedKeySpec spec = new X509EncodedKeySpec(this.publicKey);
			KeyFactory keyFactory = KeyFactory.getInstance("RSA");
			PublicKey publicKey = keyFactory.generatePublic(spec);
			
			Cipher cipher = Cipher.getInstance("RSA");
			cipher.init(Cipher.DECRYPT_MODE, publicKey);
			
			byte[] legitimationBytes = cipher.doFinal(encryptedLegitimation);
			Legitimation legitimation = Legitimation.newBuilder().mergeFrom(legitimationBytes).build();

			return legitimation;
		} catch (Exception e) {
			throw new RuntimeException("unable to decrypt legitimation");
		}
	}
}
