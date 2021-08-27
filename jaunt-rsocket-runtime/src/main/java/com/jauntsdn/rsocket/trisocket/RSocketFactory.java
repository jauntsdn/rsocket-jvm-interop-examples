package com.jauntsdn.rsocket.trisocket;

public interface RSocketFactory {

  /*Function<ServerAcceptor, Single<Disposable>>*/
  <T> T server(String name, String transport, String address);

  /*Single<RSocket> client(String name, String transport, String address)*/
  <T> T client(String name, String transport, String address);
}
