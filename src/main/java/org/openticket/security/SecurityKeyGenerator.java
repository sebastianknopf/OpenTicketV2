package org.openticket.security;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;

import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.cert.X509v3CertificateBuilder;
import org.bouncycastle.cert.jcajce.JcaX509CertificateConverter;
import org.bouncycastle.cert.jcajce.JcaX509v3CertificateBuilder;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.operator.ContentSigner;
import org.bouncycastle.operator.jcajce.JcaContentSignerBuilder;
import org.bouncycastle.util.io.pem.PemObject;
import org.bouncycastle.util.io.pem.PemWriter;

/**
 * Class for generating rsa security keys and certificates.
 */
public class SecurityKeyGenerator {

	/**
	 * Key size of 1024 bits
	 */
	public static int KEY_SIZE_1024 = 1024;

	/**
	 * Key size of 2048 bits
	 */
	public static int KEY_SIZE_2048 = 2048;

	/**
	 * Key size of 4096 bits
	 */
	public static int KEY_SIZE_4096 = 4096;

	/**
	 * Generates a new rsa key pair at the desired location. A self-signing certificate
	 * for the public key is created.
	 *
	 * @param privateFilename The filename of the private key
	 * @param publicFilename The filename of the public key
	 */
	public void generateKeyPair(String privateFilename, String publicFilename) {
		this._generateKeyPair(privateFilename, publicFilename, 1024, true);
	}

	/**
	 * Generates a new rsa key pair at the desired location and with desired key size. A self-signing certificate
	 * for the public key is created.
	 *
	 * @param privateFilename The filename of the private key
	 * @param publicFilename The filename of the public key
	 * @param keySize The key size to create
	 */
	public void generateKeyPair(String privateFilename, String publicFilename, int keySize) {
		this._generateKeyPair(privateFilename, publicFilename, keySize, true);
	}

	/**
	 * Generates a new rsa key pair at the desired location and with desired key size. A self-signing certificate
	 * for the public key is created according to the parameter.
	 *
	 * @param privateFilename The filename of the private key
	 * @param publicFilename The filename of the public key
	 * @param certifyPublic Whether to create a self-signing certificate for public key
	 */
	public void generateKeyPair(String privateFilename, String publicFilename, boolean certifyPublic) {
		this._generateKeyPair(privateFilename, publicFilename, 1024, certifyPublic);
	}

	/**
	 * Generates a new rsa key pair at the desired location and with desired key size. A self-signing certificate
	 * for the public key is created according to the parameter.
	 *
	 * @param privateFilename The filename of the private key
	 * @param publicFilename The filename of the public key
	 * @param keySize The key size to create
	 * @param certifyPublic Whether to create a self-signing certificate for public key
	 */
	public void generateKeyPair(String privateFilename, String publicFilename, int keySize, boolean certifyPublic) {
		this._generateKeyPair(privateFilename, publicFilename, keySize, certifyPublic);
	}

	/**
	 * Generates a new rsa key pair by desired parameters.
	 *
	 * @param privateFilename The filename of the private key
	 * @param publicFilename The filename of the public key / certifictae
	 * @param keySize The desired key size
	 * @param certifyPublic Whether to create a self-signing certificate for public key
	 */
	private void _generateKeyPair(String privateFilename, String publicFilename, int keySize, boolean certifyPublic) {
		try {
			KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
			kpg.initialize(keySize, new SecureRandom());
			
			KeyPair kp = kpg.generateKeyPair();
			
			this.writePemFile(privateFilename, PemObjectType.PRIVATE_KEY, kp.getPrivate().getEncoded());
			
			if (certifyPublic) {
				final Instant now = Instant.now();
				final Date notBefore = Date.from(now);
				final Date notAfter = Date.from(now.plus(Duration.ofDays(3650)));
				
				final ContentSigner contentSigner = new JcaContentSignerBuilder("SHA256WithRSAEncryption").build(kp.getPrivate());
				final X500Name x500Name = new X500Name("CN=OpenTicket Authority");
				final X509v3CertificateBuilder certBuilder = new JcaX509v3CertificateBuilder(x500Name, BigInteger.valueOf(now.toEpochMilli()), notBefore, notAfter, x500Name, kp.getPublic());
				
				X509Certificate cert = new JcaX509CertificateConverter().setProvider(new BouncyCastleProvider()).getCertificate(certBuilder.build(contentSigner));
				this.writePemFile(publicFilename, PemObjectType.CERTIFICATE, cert.getEncoded());
			} else {
				this.writePemFile(publicFilename, PemObjectType.PUBLIC_KEY, kp.getPublic().getEncoded());
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Writes arbitrary binary data to a file in PEM format.
	 *
	 * @param filename The filename to write
	 * @param pemType The PEM type the file will contain
	 * @param data The byte data the file will contain
	 * @throws IOException When the writing fails
	 */
	private void writePemFile(String filename, String pemType, byte[] data) throws IOException {
		PemObject pemObject = new PemObject(pemType, data);
		PemWriter pemWriter = new PemWriter(new OutputStreamWriter(new FileOutputStream(filename)));
		
		try {
			pemWriter.writeObject(pemObject);
		} finally {
			pemWriter.close();
		}
	}
	
}
