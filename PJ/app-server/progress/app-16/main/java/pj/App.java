package pj;

import pj.handler.BoardHandler;
import pj.handler.MemberHandler;
import pj.util.Prompt;

public class App {

  public static void main(String[] args) {

    Prompt prompt = new Prompt();

    MemberHandler memberHandler = new MemberHandler(prompt, "선수 정보");
    BoardHandler boardHandler = new BoardHandler(prompt, "응원 게시판");
    BoardHandler queryHandler = new BoardHandler(prompt, "구단 건의사항");

    printTitle();

    printMenu();

    while (true) {
      String menuNo = prompt.inputString("메인> ");
      if (menuNo.equals("0")) {
        break;
      } else if (menuNo.equals("menu")) {
        printMenu();
      } else if (menuNo.equals("1")) {
        memberHandler.execute();
      } else if (menuNo.equals("2")) {
        boardHandler.service();
      } else if (menuNo.equals("3")) {
        queryHandler.service();
      } else {
        System.out.println("메뉴 번호가 옳지 않습니다.");
      }
    }

    prompt.close();
  }

  static void printMenu() {
    System.out.println("1. 선수 정보");
    System.out.println("2. 응원 게시판");
    System.out.println("3. 구단 건의사항");
    System.out.println("0. 종료");
  }

  static void printTitle() {
    System.out.println("SSG 랜더스 구단 게시판");
    System.out.println("---------------------------");
  }
}
