package pj;

import pj.handler.BoardHandler;
import pj.handler.Handler;
import pj.handler.MemberHandler;
import pj.util.ArrayList;
import pj.util.LinkedList;
import pj.util.MenuPrompt;

public class App {

  public static void main(String[] args) {

    MenuPrompt prompt = new MenuPrompt();
    prompt.appendBreadcrumb("메인", getMenu());

    Handler memberHandler = new MemberHandler(prompt, "선수 정보", new ArrayList());
    Handler boardHandler = new BoardHandler(prompt, "응원 게시판", new LinkedList());
    Handler queryHandler = new BoardHandler(prompt, "구단 건의사항", new LinkedList());

    printTitle();

    prompt.printMenu();

    loop: while (true) {
      String menuNo = prompt.inputMenu();
      switch (menuNo) {
        case "0": break loop;
        case "1": memberHandler.execute(); break;
        case "2": boardHandler.execute(); break;
        case "3": queryHandler.execute(); break;
      }
    }

    prompt.close();
  }

  static String getMenu() {
    StringBuilder menu = new StringBuilder();
    menu.append("1. 선수 정보\n");
    menu.append("2. 응원 게시판\n");
    menu.append("3. 구단 건의사항\n");
    menu.append("0. 종료\n");
    return menu.toString();
  }

  static void printTitle() {
    System.out.println("SSG 랜더스 구단 게시판");
    System.out.println("---------------------------");
  }
}
