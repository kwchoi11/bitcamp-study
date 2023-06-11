package pj;

import pj.handler.Memberhandler;
import pj.util.Prompt;

public class App {
  
  public static void main(String[] args) {

    printTitle();

    printMenu();

    while (true) {
      String menuNo = Prompt.inputString("메인> ");
      if (menuNo.equals("6")) {
        break;
      } else if (menuNo.equals("menu")) {
        printMenu();
      } else if (menuNo.equals("1")) {
        MemberHandler.inputMember();
      } else if (menuNo.equals("2")) {
        MemberHandler.printMember();
      } else if (menuNo.equals("3")) {
        MemberHandler.viewMember();
      } else if (menuNo.equals("4")) {
        MemberHandler.updateMember();
      } else if (menuNo.equals("5")) {
        MemberHandler.deleteMember();
      } else {
        System.out.println(menuNo);
      }
    }

    Prompt.close();
  }

  static void printMenu() {
    System.out.println("1. 선수 등록");
    System.out.println("2. 선수 목록");
    System.out.println("3. 선수 조회");
    System.out.println("4. 선수 정보 변경");
    System.out.println("5. 선수 삭세");
    System.out.println("6. 종료");
  }

  static void printTitle() {
    System.out.println("야구경기 라인업 관리 시스템");
    System.out.println("==================================");
  }
}
