package college.pj.util;

import java.io.IOException;

public interface ActionListener {
  void service(BreadcrumbPrompt prompt) throws IOException;
}
