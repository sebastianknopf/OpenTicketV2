# Code Usage

Most of you will use the library in your project to create and read OpenTicket messages. This section introduces 
the coding pattern and some additional information.

## Builders

Due to the use of [protocolbuffers](https://github.com/protocolbuffers/protobuf), the entire library is based on the so-called builder pattern. This means, if you want to create
an instance of any entity, you have to achieve that by using the embedded builder class of each entity.
How works this? Look a the example below!

To create an instance of a Legitimation message for example, use the following code:

```
Legitimation legitimation = Legitimation.newBuilder()
    // your setters here
   .build();
```

The static method `newBuilder()` called on `Legitimation` class returns a new instance of a `Legitimation.Builder`. You can
invoke setter methods for every field you've seen in the [data structure section](DATA_STRUCTURE.md) before. Important is the
call to the `build()` method at the end of your definition: This will create your final legitimation instance with all desired
fields set.

## Getters and Setters

Once you got an instance of a message object, you can modify all its fields by calling the corresponding
getter or setter method. Let's look at the legitimation message we've created before:

```
// setter method call
legitimation.setLegitimationId(2264120);

// getter method call
int legId = legitimation.getLegitimationId();
```

According to this, you also can check, whether a field of type object is `null` or not by calling the corresponding `has`-method:

```
// has method call
boolean hasPassenger = legitimation.hasPassenger();
```

Use this method type to avoid null pointer accesses on fields which are not initialized yet.

## Encryption and Decryption

As mentioned in the [security section](SECURITY.md), your legitimation data should be encrypted before pushing it into the envelope message
to meet all security requirements. If you want to use the cryptography tools included in the `de.openticket.security` package, you
can use the following snippet for encryption:

```
try {
    PrivateEncryptor pe = new PrivateEncryptor("00001_Private.pem");
    byte[] encryptedData = pe.encryptLegitimation(legitimation);
} catch (RuntimeException e) {
    // unable to encrypt message
}
```

The `PrivateEncryptor` class expects the filename of your private key file during construction. To decrypt an existing
legitimation message, use this snippet:

```
try {
    PublicDecryptor pd = new PublicDecryptor("00001_Public.crt");
    Legitimation legitimation = pd.decryptLegitimation(encryptedData);
} catch (RuntimeException e) {
    // unable to encrypt message: invalid data, key not matching, etc ...
}
```

As before, the `PublicDecryptor` class expects the filename of your public key certificate as first parameter
in the constructor.

## Binary Data

At the end of your creation process, you'll want to export the binary data of the envelope message for creating
for e.g. a barcode or write to a NFC tag. To do so, simply call:

```
Envelope envelope = /* create your envelope before ... */;
byte[] binary = envelope.toByteArray();
```

Of course you can also convert back each binary encoded OpenTicket message by using this snippet:

```
byte[] binary = /* read your binary data here ... */;
Envelope envelope = Envelope.newBuilder().mergeFrom(binary).build();
```

[< Data Structure](DATA_STRUCTURE.md)