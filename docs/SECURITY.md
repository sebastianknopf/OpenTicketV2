# Security

Some efforts were also put in security issues, since a legitimation replaces the analogous ticket and can also contain personal
data like passenger name and age. The two points here are authenticity and privacy.
To meet these requirements, each legitimation message should be encrypted by using a private RSA key before it is pushed into the envelope message.
According to this, reading a legitimation message requires the corresponding public key to decrypt the legitimation messages again.

This library provides a simple way to generate the required RSA key pair. You can do this by using the jar file as application
or use the `de.openticket.security` package in your own application.

To create the keys with the jar file, type in your console:

`java -jar openticket-2.0.0.jar keygen -private 00001_Private.pem -public 00001_Public.crt -s 1024`

In your application code, the following snippet will do this:

```
SecurityKeyGenerator skg = new SecurityKeyGenerator();

// create a key with size of 1024 bits, with self-signing public key certificate
skg.generateKeyPair("00001_Private.pem", "00001_Public.crt");

// create a key with size of 2048 bits, with self-signing public key certificate
skg.generateKeyPair("00001_Private.pem", "00001_Public.crt", SecurityKeyGenerator.KEY_SIZE_2048);

// create a key pair with size of 1024 bits, without public key certificate
skg.generateKeyPair("00001_Private.pem", "00001_Public.pem", false);

// create a key pair with size of 2048 bits, without public certificate
skg.generateKeyPair("00001_Private.pem", "00001_Public.pem", SecurityKeyGenerator.KEY_SIZE_2048, false);
```

*Note: The size of your key limits the maximum size of your Legitimation message by using the `de.openticket.security` package! The Legitimation bytes
must be max. 128 bytes for a 1024 bits key, max. 256 bytes for a 2048 bits key and so on...*

It is recommended that you store especially the private key file on a storage location, where no unauthorized
users can access them! Otherwise everybody having access to the private key file will be able to create valid legitimation
messages! If your legitimation messages can also contain personal information like passenger names in combination with their
age, you also should be aware of the user group, which will have access to the public key certificate, since this would enable
a user to view these personal information.

The `de.openticket.security`package is only a helper, you can encrypt / decrypt your legitimation messages with any method 
you want.

[< General Notes](GENERAL_NOTES.md) | [Data Structure >](DATA_STRUCTURE.md)