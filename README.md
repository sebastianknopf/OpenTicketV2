# OpenTicket V2
Open source encoding standard for e-tickets in public transportation

## General
Electronic tickets (e-tickets) in public transportation became more and more important since mobile
devices were developed very fast within the last ten years. 

This project can be classified anywhere between the widely used standard of UIC918.3 and the VDV-KA, but with very simplified
information contents. Sadly the most standards (or at least their full specification) are not open and cannot be viewed
by everyone which is the main purpose of inventing this library.

In the current version (V2) the well known [protocolbuffers](https://github.com/protocolbuffers/protobuf) standard designed by google is used to encode the information. The definition
script [OpenTicket.proto](./OpenTicket.proto) allows you to create a port to your desired programming language by using the **protoc** compiler.

## Usage

To use this library in your project, you can either link your build path to the *.jar file from
the releases. See the [documentation](docs/README.md) for more information.

## License

This project is licensed under the Apache 2.0 License. See [LICENSE](LICENSE.md) for more information.