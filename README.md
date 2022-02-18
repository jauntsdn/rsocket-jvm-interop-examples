# RSocket-JVM libraries / GRPC interop demonstration

[Example](https://vimeo.com/619613045) application is comprised of 5 RSocket-RPC services (RSocket-JVM runtimes are stripped),
and one GRPC client:    

* [Farmer](https://github.com/jauntsdn/rsocket-jvm-interop-examples/blob/feature/oss/jaunt-rsocket-reactor-service/src/main/java/com/jauntsdn/rsocket/trisocket/farm/Main.java) service (RSocket-reactor + TCP transport)

* [Recipes](https://github.com/jauntsdn/rsocket-jvm-interop-examples/blob/feature/oss/jaunt-rsocket-futures-service/src/main/java/com/jauntsdn/rsocket/trisocket/recipes/Main.java) service (RSocket-reactor + TCP transport)

* [Roundsman](https://github.com/jauntsdn/rsocket-jvm-interop-examples/blob/feature/oss/jaunt-rsocket-mutiny-service/src/main/java/com/jauntsdn/rsocket/trisocket/roundsman/Main.java) service (RSocket-mutiny + WEBSOCKET-HTTP2 transport)

* [Chef](https://github.com/jauntsdn/rsocket-jvm-interop-examples/blob/feature/oss/jaunt-rsocket-helidon-service/src/main/java/com/jauntsdn/rsocket/trisocket/chef/Main.java) service (RSocket-helidon + UNIX transport)
 
* [Kitchen](https://github.com/jauntsdn/rsocket-jvm-interop-examples/blob/feature/oss/jaunt-rsocket-rxjava-service/src/main/java/com/jauntsdn/rsocket/trisocket/kitchen/Main.java) service (RSocket-rxjava + GRPC transport)

* [Gourmet](https://github.com/jauntsdn/rsocket-jvm-interop-examples/blob/feature/oss/grpc-client/src/main/java/com/jauntsdn/rsocket/trisocket/gourmet/Main.java) client (GRPC-java)

### Build

`./gradlew`

Regenerate RPC client/service stubs (linux, windows(x86) only)

`./gradlew clean build -PgenerateProto=true`

