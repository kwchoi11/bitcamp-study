package pj;

import pj.handler.BoardHandler;
import pj.handler.MemberHandler;
import pj.util.Prompt;

public class App {

  public static void main(String[] args) {

    Prompt prompt = new Prompt();

    MemberHandler memberHandler = new MemberHandler(prompt);
    BoardHandler boardHandler = new BoardHandler(prompt);
    BoardHandler queryHandler = new BoardHandler(prompt);

    printTitle();

    printMenu();

    while (true) {
      String menuNo = prompt.inputString("메인> ");
      if (menuNo.equals("0")) {
        break;
      } else if (menuNo.equals("menu")) {
        printMenu();
      } else if (menuNo.equals("1")) {
        memberHandler.inputMember();
      } else if (menuNo.equals("2")) {
        memberHandler.printMembers();
      } else if (menuNo.equals("3")) {
        memberHandler.viewMember();
      } else if (menuNo.equals("4")) {
        memberHandler.updateMember();
      } else if (menuNo.equals("5")) {
        memberHandler.deleteMember();
      } else if (menuNo.equals("6")) {
        boardHandler.inputBoard();
      } else if (menuNo.equals("7")) {
        boardHandler.printBoards();
      } else if (menuNo.equals("8")) {
        boardHandler.viewBoard();
      } else if (menuNo.equals("9")) {
        boardHandler.updateBoard();
      } else if (menuNo.equals("10")) {
        boardHandler.deleteBoard();
      } else if (menuNo.equals("11")) {
        queryHandler.inputBoard();
      } else if (menuNo.equals("12")) {
        queryHandler.printBoards();
      } else if (menuNo.equals("13")) {
        queryHandler.viewBoard();
      } else if (menuNo.equals("14")) {
        queryHandler.updateBoard();
      } else if (menuNo.equals("15")) {
        queryHandler.deleteBoard();
      } else {
        System.out.println("메뉴 번호가 옳지 않습니다.");
      }
    }

    prompt.close();
  }

  static void printMenu() {
    System.out.println("1. 선수 등록");
    System.out.println("2. 선수 목록");
    System.out.println("3. 선수 조회");
    System.out.println("4. 선수 정보 변경");
    System.out.println("5. 선수 삭제");
    System.out.println("6. 응원글 등록");
    System.out.println("7. 응원글 목록");
    System.out.println("8. 응원글 조회");
    System.out.println("9. 응원글 변경");
    System.out.println("10. 응원글 삭제");
    System.out.println("11. 건의사항 등록");
    System.out.println("12. 건의사항 목록");
    System.out.println("13. 건의사항 조회");
    System.out.println("14. 건의사항 변경");
    System.out.println("15. 건의사항 삭제");
    System.out.println("0. 종료");
  }

  static void printTitle() {
    System.out.println("SSG 랜더스 구단 게시판");
    System.out.println("---------------------------");
  }
}
