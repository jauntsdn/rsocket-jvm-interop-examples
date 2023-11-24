/*
 * Copyright 2020 - present Maksym Ostroverkhov.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.jauntsdn.rsocket.trisocket.gourmet;

import io.grpc.netty.shaded.io.netty.handler.ssl.ApplicationProtocolConfig;
import io.grpc.netty.shaded.io.netty.handler.ssl.ApplicationProtocolNames;
import io.grpc.netty.shaded.io.netty.handler.ssl.OpenSsl;
import io.grpc.netty.shaded.io.netty.handler.ssl.SslContext;
import io.grpc.netty.shaded.io.netty.handler.ssl.SslContextBuilder;
import io.grpc.netty.shaded.io.netty.handler.ssl.SslProvider;
import io.grpc.netty.shaded.io.netty.handler.ssl.SupportedCipherSuiteFilter;
import io.grpc.netty.shaded.io.netty.handler.ssl.util.InsecureTrustManagerFactory;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLException;

public final class Security {

  public static SslContext clientLocalSslContext() {
    try {
      return clientSslContextBuilder().trustManager(InsecureTrustManagerFactory.INSTANCE).build();
    } catch (SSLException e) {
      throw new RuntimeException("TLS error", e);
    }
  }

  private static SslContextBuilder clientSslContextBuilder() {
    return SslContextBuilder.forClient()
        .protocols("TLSv1.3")
        .sslProvider(sslProvider())
        .applicationProtocolConfig(alpnConfig())
        .ciphers(CIPHERS, SupportedCipherSuiteFilter.INSTANCE);
  }

  private static ApplicationProtocolConfig alpnConfig() {
    return new ApplicationProtocolConfig(
        ApplicationProtocolConfig.Protocol.ALPN,
        ApplicationProtocolConfig.SelectorFailureBehavior.NO_ADVERTISE,
        ApplicationProtocolConfig.SelectedListenerFailureBehavior.ACCEPT,
        ApplicationProtocolNames.HTTP_2);
  }

  private static SslProvider sslProvider() {
    final SslProvider sslProvider;
    if (OpenSsl.isAvailable()) {
      sslProvider = SslProvider.OPENSSL_REFCNT;
    } else {
      sslProvider = SslProvider.JDK;
    }
    return sslProvider;
  }

  private static final List<String> CIPHERS =
      Collections.unmodifiableList(
          Arrays.asList(
              "TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256",
              "TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256",
              "TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384",
              "TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384",
              "TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256",
              "TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256",
              "TLS_AES_128_GCM_SHA256",
              "TLS_AES_256_GCM_SHA384",
              "TLS_CHACHA20_POLY1305_SHA256"));
}
