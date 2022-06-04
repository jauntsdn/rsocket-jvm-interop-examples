package com.jauntsdn.rsocket.trisocket;

public interface RSocketFactory {

  /*Function<ServerAcceptor, Single<Disposable>>*/
  <T> T server(String name, String transport, String address);

  /*Single<MessageStreams> client(String name, String transport, String address)*/
  <T> T client(String name, String transport, String address);

  interface Server<T, U> {
    U start(T t);
  }
}
