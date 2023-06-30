package pj;

import pj.handler.Handler;
import pj.util.MenuPrompt;

public class App {

  public static void main(String[] args) {

    MeunuPrompt prompt = new MenuPrompt();
    prompt.appendBreadcrumb("메인", getMenu());

    Handler memberHandler = new MemberHandler(prompt, "선수단", new ArrayList());
    Handler boardHandler = new BoardHandler(prompt, "응원 게시판", new LinkedList());
    Handler


  }
}
