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
    System.out.println("SSG 랜더스");
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
    loadCsv("member.csv", memberList, Member.class);
    loadCsv("board.csv", boardList, Board.class);
    loadCsv("reading.csv", queryList, Board.class);
  }

  private void saveData() {
    saveCsv("member.csv", memberList);
    saveCsv("board.csv", boardList);
    saveCsv("reading.csv", queryList);
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

    MenuGroup readingMenu = new MenuGroup("건의사항");
    readingMenu.add(new Menu("등록", new BoardAddListener(queryList)));
    readingMenu.add(new Menu("목록", new BoardListListener(queryList)));
    readingMenu.add(new Menu("조회", new BoardDetailListener(queryList)));
    readingMenu.add(new Menu("변경", new BoardUpdateListener(queryList)));
    readingMenu.add(new Menu("삭제", new BoardDeleteListener(queryList)));
    mainMenu.add(readingMenu);

    MenuGroup computeMenu = new MenuGroup("기록 계산");
    computeMenu.add(new Menu("평균 자책점 계산하기"));
    computeMenu.add(new Menu("WHIP 계산하기"));
    computeMenu.add(new Menu("타율 계산하기"));
    computeMenu.add(new Menu("OPS 계한하기"));
  }

  @SuppressWarnings("unchecked")
  private <T extends CsvObject> void loadCsv(String filename, List<T> list, Class<T> clazz) {
    try {
      Method factoryMethod = clazz.getDeclaredMethod("fromCsv", String.class);

      FileReader in0 = new FileReader(filename);
      BufferedReader in = new BufferedReader(in0); // <== Decorator 역할을 수행!

      String line = null;

      while ((line = in.readLine()) != null) {
        list.add((T) factoryMethod.invoke(null, line)); // Reflection API를 사용하여 스태틱 메서드 호출
        // list.add(Member.fromCsv(line)); // 직접 스태틱 메서드 호출
      }

      in.close();

    } catch (Exception e) {
      System.out.println(filename + " 파일을 읽는 중 오류 발생!");
    }
  }

  private void saveCsv(String filename, List<? extends CsvObject> list) {
    try {
      FileWriter out0 = new FileWriter(filename);
      BufferedWriter out1 = new BufferedWriter(out0); // <== Decorator(장식품) 역할 수행!
      PrintWriter out = new PrintWriter(out1); // <== Decorator(장식품) 역할 수행!

      for (CsvObject obj : list) {
        out.println(obj.toCsvString());
        // Board나 Member 클래스에 필드가 추가/변경/삭제되더라도
        // 여기 코드를 변경할 필요가 없다.
        // 이것이 Information Expert 설계를 적용하는 이유다!
        // 설계를 어떻게 하느냐에 따라 유지보수가 쉬워질 수도 있고,
        // 어려워질 수도 있다.
      }
      out.close();

    } catch (Exception e) {
      System.out.println(filename + " 파일을 저장하는 중 오류 발생!");
    }
  }
}
