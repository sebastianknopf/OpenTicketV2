The OpenTicket library uses a flexible encoding standard for displaying all required information
of a conventional ticket in public transportation. The whole message format is defined 
in the [OpenTicket.proto](/OpenTicket.proto) file. It's easy for you to create your own wrapper of
this library in your desired language by compiling the *.proto file. Take a look into the documentation
of [protocolbuffers](https://github.com/protocolbuffers/protobuf) to see how you can achieve this.

Every OpenTicket data message consists of a container - called *Envelope*. To store the ticket information itself
the message type *Legitimation* is used, which is later pushed into the envelope message. The envelope message itself contains information about the RSA key used for 
encryption and a chunk of arbitrary byte data containing at least one encrypted legitimation message. The resulting bytes can be stored on each medium you want, for e.g. a barcode or a smart card.
The only requirement is that your desired storage medium offers a way to store binary data.

There's no restriction in any way, how you maintain the data used within a legitimation message. You should think
about the required infrastructure in the background

[Security >](SECURITY.md)