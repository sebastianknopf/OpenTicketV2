package org.openticket.security;

/**
 * Helper class for holding PEM object types.
 */
public class PemObjectType {

	public static String CERTIFICATE = "CERTIFICATE";
	public static String PRIVATE_KEY = "PRIVATE KEY";
	public static String PUBLIC_KEY = "PUBLIC KEY";

	// make private to avoid creating an object instance
	private PemObjectType() {
		
	}
	
}
