package pj;

import pj.handler.BoardHandler;
import pj.handler.MemberHandler;
import pj.util.Prompt;

public class App {

  public static void main(String[] args) {

    printTitle();

    printMenu();

    while (true) {
      String menuNo = Prompt.inputString("메인> ");
      if (menuNo.equals("0")) {
        break;
      } else if (menuNo.equals("menu")) {
        printMenu();
      } else if (menuNo.equals("1")) {
        MemberHandler.inputMember();
      } else if (menuNo.equals("2")) {
        MemberHandler.printMembers();
      } else if (menuNo.equals("3")) {
        MemberHandler.viewMember();
      } else if (menuNo.equals("4")) {
        MemberHandler.updateMember();
      } else if (menuNo.equals("5")) {
        MemberHandler.deleteMember();
      } else if (menuNo.equals("6")) {
        BoardHandler.inputBoard();
      } else if (menuNo.equals("7")) {
        BoardHandler.printBoards();
      } else if (menuNo.equals("8")) {
        BoardHandler.viewBoard();
      } else if (menuNo.equals("9")) {
        BoardHandler.updateBoard();
      } else if (menuNo.equals("10")) {
        BoardHandler.deleteBoard();
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
    System.out.println("5. 선수 삭제");
    System.out.println("6. 게시글 등록");
    System.out.println("7. 게시글 목록");
    System.out.println("8. 게시글 조회");
    System.out.println("9. 게시글 변경");
    System.out.println("10. 게시글 삭제");
    System.out.println("0. 종료");
  }

  static void printTitle() {
    System.out.println("SSG 랜더스 구단 게시판");
    System.out.println("---------------------------");
  }
}
