package com.jauntsdn.rsocket.trisocket;

import com.jauntsdn.rsocket.Rpc;
import java.util.Arrays;
import java.util.List;

public interface RSocketFactory {

  /*Function<ServerAcceptor, Single<Disposable>>*/
  default <T> T server(String name, String transport, String address) {
    throw new UnsupportedOperationException("single-protocol transport not implemented");
  }

  /*Function<ServerAcceptor, Single<Disposable>>*/
  default <T> T multiProtocolServer(String name, MultiProtocolTransport multiProtocolTransport) {
    throw new UnsupportedOperationException("multi-protocol transport not implemented");
  }

  /*Single<MessageStreams> client(String name, String transport, String address)*/
  <T> T client(String name, String transport, String address);

  interface Server<T, U> {
    U start(T t);
  }

  class MultiProtocolTransport {
    final String address;
    final List<Protocol> transports;

    private MultiProtocolTransport(String address, List<Protocol> transports) {
      this.address = address;
      this.transports = transports;
    }

    public static MultiProtocolTransport of(String address, Protocol... protocols) {
      return new MultiProtocolTransport(address, Arrays.asList(protocols));
    }

    public String address() {
      return address;
    }

    public List<Protocol> protocols() {
      return transports;
    }

    public static class Protocol {
      final String name;

      Protocol(String name) {
        this.name = name;
      }

      public String name() {
        return name;
      }

      @Override
      public String toString() {
        return name;
      }

      public TranscodedTransport asTranscoded() {
        if (this instanceof TranscodedTransport) {
          return (TranscodedTransport) this;
        }
        throw new UnsupportedOperationException("Is not transcoded transport: " + this.getClass());
      }

      public static Protocol of(String name) {
        return new Protocol(name);
      }

      public static Protocol ofTranscoded(String name, Rpc.ServiceDescriptor serviceDescriptor) {
        return new TranscodedTransport(name, serviceDescriptor);
      }
    }

    public static final class TranscodedTransport extends Protocol {
      final Rpc.ServiceDescriptor serviceDescriptor;

      TranscodedTransport(String name, Rpc.ServiceDescriptor serviceDescriptor) {
        super(name);
        this.serviceDescriptor = serviceDescriptor;
      }

      public Rpc.ServiceDescriptor serviceDescriptor() {
        return serviceDescriptor;
      }
    }
  }
}
