package bitcamp.util;

import reactor.netty.http.server.HttpServerRequest;
import reactor.netty.http.server.HttpServerResponse;

public interface Servlet {
  void service(HttpServerRequest request, HttpServerResponse response) throws Exception;
}
