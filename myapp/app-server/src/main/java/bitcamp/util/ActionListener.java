package bitcamp.util;

import java.io.IOException;

public interface ActionListener {
  void service(HttpServletRequest request, HttpServletResponse response) throws IOException;
}
