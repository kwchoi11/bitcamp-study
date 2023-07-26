package pj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import pj.handler.BatterAddListener;
import pj.handler.BatterDeleteListener;
import pj.handler.BatterDetailListener;
import pj.handler.BatterListListener;
import pj.handler.BatterUpdateListener;
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
import pj.handler.PitcherAddListener;
import pj.handler.PitcherDeleteListener;
import pj.handler.PitcherDetailListener;
import pj.handler.PitcherListListener;
import pj.handler.PitcherUpdateListener;
import pj.util.BreadcrumbPrompt;
import pj.util.Menu;
import pj.util.MenuGroup;
import pj.vo.AutoIncrement;
import pj.vo.BatterBoard;
import pj.vo.Board;
import pj.vo.Member;
import pj.vo.PitcherBoard;

public class App {

  ArrayList<Member> memberList = new ArrayList<>();
  LinkedList<Board> boardList = new LinkedList<>();
  LinkedList<Board> queryList = new LinkedList<>();
  LinkedList<PitcherBoard> pitcherList = new LinkedList<>();
  LinkedList<BatterBoard> batterList = new LinkedList<>();

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
    loadJson("members.json", memberList, Member.class);
    loadJson("pitchers.json", pitcherList, PitcherBoard.class);
    loadJson("batters.json", batterList, BatterBoard.class);
    loadJson("boards.json", boardList, Board.class);
    loadJson("queries.json", queryList, Board.class);
  }

  private void saveData() {
    saveJson("members.json", memberList);
    saveJson("pitchers.json", pitcherList);
    saveJson("batters.json", batterList);
    saveJson("boards.json", boardList);
    saveJson("queries.json", queryList);
  }

  private void prepareMenu() {
    MenuGroup memberMenu = new MenuGroup("선수 정보");
    memberMenu.add(new Menu("등록", new MemberAddListener(memberList)));
    memberMenu.add(new Menu("목록", new MemberListListener(memberList)));
    memberMenu.add(new Menu("조회", new MemberDetailListener(memberList)));
    memberMenu.add(new Menu("변경", new MemberUpdateListener(memberList)));
    memberMenu.add(new Menu("삭제", new MemberDeleteListener(memberList)));
    mainMenu.add(memberMenu);

    MenuGroup pitcherMenu = new MenuGroup("투수 기록");
    pitcherMenu.add(new Menu("등록", new PitcherAddListener(pitcherList)));
    pitcherMenu.add(new Menu("목록", new PitcherListListener(pitcherList)));
    pitcherMenu.add(new Menu("조회", new PitcherDetailListener(pitcherList)));
    pitcherMenu.add(new Menu("변경", new PitcherUpdateListener(pitcherList)));
    pitcherMenu.add(new Menu("삭제", new PitcherDeleteListener(pitcherList)));
    mainMenu.add(pitcherMenu);

    MenuGroup batterMenu = new MenuGroup("타자 기록");
    batterMenu.add(new Menu("등록", new BatterAddListener(batterList)));
    batterMenu.add(new Menu("목록", new BatterListListener(batterList)));
    batterMenu.add(new Menu("조회", new BatterDetailListener(batterList)));
    batterMenu.add(new Menu("변경", new BatterUpdateListener(batterList)));
    batterMenu.add(new Menu("삭제", new BatterDeleteListener(batterList)));
    mainMenu.add(batterMenu);

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

  private <T> void loadJson(String filename, List<T> list, Class<T> clazz) {
    try {
      FileReader in0 = new FileReader(filename);
      BufferedReader in = new BufferedReader(in0); // <== Decorator 역할을 수행

      StringBuilder strBuilder = new StringBuilder();
      String line = null;

      while ((line = in.readLine()) != null) {
        strBuilder.append(line);
      }

      in.close();

      Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
      Collection<T> objects = gson.fromJson(strBuilder.toString(),
          TypeToken.getParameterized(Collection.class, clazz).getType());

      list.addAll(objects);

      Class<?>[] interfaces = clazz.getInterfaces();
      for (Class<?> info : interfaces) {
        if (info == AutoIncrement.class) {
          AutoIncrement autoIncrement = (AutoIncrement) list.get(list.size() - 1);
          autoIncrement.updateKey();
          break;
        }
      }

    } catch (Exception e) {
      System.out.println(filename + " 파일을 읽는 중 오류 발생!");
    }
  }

  private void saveJson(String filename, List<?> list) {
    try {
      FileWriter out0 = new FileWriter(filename);
      BufferedWriter out = new BufferedWriter(out0);

      Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").setPrettyPrinting().create();
      out.write(gson.toJson(list));

      out.close();

    } catch (Exception e) {
      System.out.println(filename + " 파일을 저장하는 중 오류 발생!");
    }
  }
}
