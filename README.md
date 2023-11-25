![Message-Streams](readme/mstreams.png)

[![Build](https://github.com/jauntsdn/rsocket-jvm-interop-examples/actions/workflows/build-ci.yml/badge.svg)](https://github.com/jauntsdn/rsocket-jvm-interop-examples/actions/workflows/build-ci.yml)
# Message-Streams (RSocket-JVM) / GRPC interop example

This example demonstrates how `Message-Streams` services from [jauntsdn/RSocket-JVM](https://github.com/jauntsdn/rsocket-jvm) 
interoperate with each other over multiple transports (tcp, unix sockets, websockets/http2) & with GRPC, http/json over http2. It also demonstrates 
how Message-Streams/RPC services may be decoupled from RSocket-JVM runtime (this includes transports, metrics, load estimators/circuit breakers).

`Message-Streams` is very fast GRPC-like & GRPC-compatible services on JVM with rich streaming models.

Each service & its RPC client/server bindings have API of different nature: grpc-stub API(StreamObserver), CompletableFuture, 
or flavor of reactive: smallrye-mutiny, rxjava3, reactor-project.

Example application is comprised of 5 `Message-Streams` services (RSocket-JVM runtimes are stripped on this branch),
plus GRPC & http/json clients:    

* [Farmer](https://github.com/jauntsdn/rsocket-jvm-interop-examples/blob/feature/oss/messagestreams-reactor-service/src/main/java/com/jauntsdn/rsocket/trisocket/farm/Main.java) service (Message-Streams-RPC-reactor + TCP transport)

* [Recipes](https://github.com/jauntsdn/rsocket-jvm-interop-examples/blob/feature/oss/messagestreams-futures-service/src/main/java/com/jauntsdn/rsocket/trisocket/recipes/Main.java) service (Message-Streams-RPC-futures + TCP transport)

* [Roundsman](https://github.com/jauntsdn/rsocket-jvm-interop-examples/blob/feature/oss/messagestreams-mutiny-service/src/main/java/com/jauntsdn/rsocket/trisocket/roundsman/Main.java) service (Message-Streams-RPC-mutiny + WEBSOCKET-HTTP2 transport)

* [Chef](https://github.com/jauntsdn/rsocket-jvm-interop-examples/blob/feature/oss/messagestreams-grpc-service/src/main/java/com/jauntsdn/rsocket/trisocket/chef/Main.java) service (Message-Streams-RPC-grpc + UNIX transport)
 
* [Kitchen](https://github.com/jauntsdn/rsocket-jvm-interop-examples/blob/feature/oss/messagestreams-rxjava-service/src/main/java/com/jauntsdn/rsocket/trisocket/kitchen/Main.java) service (Message-Streams-RPC-rxjava + GRPC transport)

* [Gourmet](https://github.com/jauntsdn/rsocket-jvm-interop-examples/blob/feature/oss/grpc-client/src/main/java/com/jauntsdn/rsocket/trisocket/gourmet/Main.java) client (GRPC-java)

* [Supervisor](https://github.com/jauntsdn/rsocket-jvm-interop-examples/blob/feature/oss/http-client/src/main/java/com/jauntsdn/rsocket/trisocket/supervisor/Main.java) client (http/json)

![services](readme/mstreams-interop-svcs.png "services")

### Build

`./gradlew`

Regenerate RPC client/service stubs (linux, windows(x86) only)

`./gradlew clean build -PgenerateProto=true`

