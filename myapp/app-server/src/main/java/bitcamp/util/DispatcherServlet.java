package bitcamp.util;

import java.io.PrintWriter;
import reactor.netty.http.server.HttpServerRequest;
import reactor.netty.http.server.HttpServerResponse;

public class DispatcherServlet implements Servlet {

  ApplicationContext iocContainer;

  public DispatcherServlet(ApplicationContext iocContainer) throws Exception {
    this.iocContainer = iocContainer;
  }

  @Override
  public void service(HttpServerRequest request, HttpServerResponse response) throws Exception {

    PrintWriter out = response.getWriter();
    out.println("Hello World");
    out.println("반가워요");
    //    ActionListener listener = (ActionListener) iocContainer.getBean((String) prompt.getAttribute("menuPath"));
    //    if (listener == null) {
    //      throw new RuntimeException("해당 요청을 처리할 수 없습니다.");
    //    }
    //    listener.service(prompt);
  }
}
