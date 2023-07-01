package pj.handler;

import pj.util.ActionListener;
import pj.util.BreadcrumbPrompt;

public class HeaderListener implements ActionListener {
  @Override
  public void service(BreadcrumbPrompt prompt) {
    System.out.println("=============================[비트캠프!]==");
  }
}
