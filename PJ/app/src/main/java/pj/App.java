package pj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import pj.handler.BoardAddListener;
import pj.handler.BoardDeleteListener;
import pj.handler.BoardDetailListener;
import pj.handler.BoardListListener;
import pj.handler.BoardUpdateListener;
import pj.handler.MemberAddListener;
import pj.handler.MemberDeleteListener;
import pj.handler.MemberDetailListener;
import pj.handler.MemberListListener;
import pj.handler.MemberUpdateListener;
import pj.util.BreadcrumbPrompt;
import pj.util.Menu;
import pj.util.MenuGroup;
import pj.vo.Board;
import pj.vo.CsvObject;
import pj.vo.Member;

public class App {

  ArrayList<Member> memberList = new ArrayList<>();
  LinkedList<Board> boardList = new LinkedList<>();
  LinkedList<Board> queryList = new LinkedList<>();

  BreadcrumbPrompt prompt = new BreadcrumbPrompt();

  MenuGroup mainMenu = new MenuGroup("메인");

  public App() {
    prepareMenu();
  }

  public static void main(String[] args) {
    new App().execute();
  }

  static void printTitle() {
    System.out.println("SSG Landers 구단 게시판");
    System.out.println("----------------------------------");
  }

  public void execute() {
    printTitle();

    loadData();
    mainMenu.execute(prompt);
    saveData();

    prompt.close();
  }

  private void loadData() {
    loadCsv("members.csv", memberList, Member.class);
    loadCsv("boards.csv", boardList, Board.class);
    loadCsv("queries.csv", queryList, Board.class);
  }

  private void saveData() {
    saveCsv("members.csv", memberList);
    saveCsv("boards.csv", boardList);
    saveCsv("queries.csv", queryList);
  }

  private void prepareMenu() {
    MenuGroup memberMenu = new MenuGroup("선수 정보");
    memberMenu.add(new Menu("등록", new MemberAddListener(memberList)));
    memberMenu.add(new Menu("목록", new MemberListListener(memberList)));
    memberMenu.add(new Menu("조회", new MemberDetailListener(memberList)));
    memberMenu.add(new Menu("변경", new MemberUpdateListener(memberList)));
    memberMenu.add(new Menu("삭제", new MemberDeleteListener(memberList)));
    mainMenu.add(memberMenu);

    MenuGroup boardMenu = new MenuGroup("응원 게시판");
    boardMenu.add(new Menu("등록", new BoardAddListener(boardList)));
    boardMenu.add(new Menu("목록", new BoardListListener(boardList)));
    boardMenu.add(new Menu("조회", new BoardDetailListener(boardList)));
    boardMenu.add(new Menu("변경", new BoardUpdateListener(boardList)));
    boardMenu.add(new Menu("삭제", new BoardDeleteListener(boardList)));
    mainMenu.add(boardMenu);

    MenuGroup readingMenu = new MenuGroup("구단 건의사항");
    readingMenu.add(new Menu("등록", new BoardAddListener(queryList)));
    readingMenu.add(new Menu("목록", new BoardListListener(queryList)));
    readingMenu.add(new Menu("조회", new BoardDetailListener(queryList)));
    readingMenu.add(new Menu("변경", new BoardUpdateListener(queryList)));
    readingMenu.add(new Menu("삭제", new BoardDeleteListener(queryList)));
    mainMenu.add(readingMenu);
  }

  @SuppressWarnings("unchecked")
  private <T extends CsvObject> void loadCsv(String filename, List<T> list, Class<T> clazz) {
    try {
      Method factoryMethod = clazz.getDeclaredMethod("fromCsv", String.class);

      FileReader in0 = new FileReader(filename);
      BufferedReader in = new BufferedReader(in0);

      String line = null;

      while ((line = in.readLine()) != null) {
        list.add((T) factoryMethod.invoke(null, line));
      }

      in.close();

    } catch (Exception e) {
      System.out.println(filename + " 파일을 읽는 중 오류 발생!");
    }
  }

  private void saveCsv(String filename, List<? extends CsvObject> list) {
    try {
      FileWriter out0 = new FileWriter(filename);
      BufferedWriter out1 = new BufferedWriter(out0);
      PrintWriter out = new PrintWriter(out1);

      for (CsvObject obj : list) {
        out.println(obj.toCsvString());
      }
      out.close();

    } catch (Exception e) {
      System.out.println(filename + " 파일을 저장하는 중 오류 발생!");
    }
  }
}
