package org.openticket.security;

import org.openticket.Legitimation;
import org.bouncycastle.util.io.pem.PemObject;
import org.bouncycastle.util.io.pem.PemReader;

import javax.crypto.Cipher;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;

public class PrivateEncryptor {

    /**
     * The private key raw bytes.
     */
    private byte[] privateKey;

    /**
     * Creates a new instance of PrivateEncryptor class by loading a private key in PEM format.
     *
     * @param privateFilename
     */
    public PrivateEncryptor(String privateFilename) {
        PemReader pemReader = null;

        try {
            pemReader = new PemReader(new InputStreamReader(new FileInputStream(privateFilename)));
            PemObject pemObject = pemReader.readPemObject();

            if (pemObject.getType().equals(PemObjectType.PRIVATE_KEY)) {
                this.privateKey = pemObject.getContent();
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            throw new RuntimeException("cannot read " + privateFilename);
        } finally {
            try {
                pemReader.close();
            } catch (IOException e) {
            }
        }
    }

    /**
     * Encrypts a Legitimation message to raw bytes.
     *
     * @param legitimation The Legitimation message to encrypt
     * @return The encrypted legitimation bytes
     * @throws RuntimeException When the encryption failed
     */
    public byte[] encryptLegitimation(Legitimation legitimation) throws RuntimeException {
        try {
            PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(this.privateKey);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PrivateKey privateKey = keyFactory.generatePrivate(spec);

            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.ENCRYPT_MODE, privateKey);

            return cipher.doFinal(legitimation.toByteArray());
        } catch (Exception e) {
            throw new RuntimeException("unable to encrypt legitimation");
        }
    }
}
