# RSocket-JVM libraries / GRPC interop demonstration

[Trisocket](https://vimeo.com/619613045) application (RSocket-reactor+TCP/rxjava+GRPC/helidon+UNIX) with RSocket-JVM runtimes stripped

### Build

`./gradlew`

Regenerate RPC client/service stubs (linux only)

`./gradlew clean build -PgenerateProto=true`

