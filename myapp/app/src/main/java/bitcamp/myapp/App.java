package bitcamp.myapp;

import bitcamp.myapp.handler.BoardAddListener;
import bitcamp.myapp.handler.BoardDeleteListener;
import bitcamp.myapp.handler.BoardDetailListener;
import bitcamp.myapp.handler.BoardListListener;
import bitcamp.myapp.handler.BoardUpdateListener;
import bitcamp.myapp.handler.Handler;
import bitcamp.myapp.handler.MemberHandler;
import bitcamp.util.ArrayList;
import bitcamp.util.BreadcrumbPrompt;
import bitcamp.util.LinkedList;
import bitcamp.util.Menu;
import bitcamp.util.MenuGroup;

public class App {

  public static void main(String[] args) {

    LinkedList boardList = new LinkedList();

    BreadcrumbPrompt prompt = new BreadcrumbPrompt();


    MenuGroup mainMenu = new MenuGroup("메인");

    MenuGroup memberMenu = new MenuGroup("회원");
    memberMenu.add(new Menu("등록"));
    memberMenu.add(new Menu("목록"));
    memberMenu.add(new Menu("조회"));
    memberMenu.add(new Menu("변경"));
    memberMenu.add(new Menu("삭제"));
    mainMenu.add(memberMenu);

    MenuGroup boardMenu = new MenuGroup("게시글");
    boardMenu.add(new Menu("등록", new BoardAddListener(boardList)));
    boardMenu.add(new Menu("목록", new BoardListListener(boardList)));
    boardMenu.add(new Menu("조회", new BoardDetailListener(boardList)));
    boardMenu.add(new Menu("변경", new BoardUpdateListener(boardList)));
    boardMenu.add(new Menu("삭제", new BoardDeleteListener(boardList)));
    mainMenu.add(boardMenu);

    MenuGroup readingMenu = new MenuGroup("독서록");

    readingMenu.add(new Menu("등록"));
    readingMenu.add(new Menu("목록"));
    readingMenu.add(new Menu("조회"));
    readingMenu.add(new Menu("변경"));
    readingMenu.add(new Menu("삭제"));
    mainMenu.add(readingMenu);

    Handler memberHandler = new MemberHandler(prompt, "회원", new ArrayList());
    Handler boardHandler = new BoardDeleteListener(prompt, "게시글", new LinkedList());
    Handler readingHandler = new BoardDeleteListener(prompt, "독서록", new LinkedList());

    printTitle();

    mainMenu.execute(prompt);

    prompt.close();
  }

  static String getMenu() {
    StringBuilder menu = new StringBuilder();
    menu.append("1. 회원\n");
    menu.append("2. 게시글\n");
    menu.append("3. 독서록\n");
    menu.append("0. 종료\n");
    return menu.toString();
  }

  static void printTitle() {
    System.out.println("나의 목록 관리 시스템");
    System.out.println("----------------------------------");
  }

}
