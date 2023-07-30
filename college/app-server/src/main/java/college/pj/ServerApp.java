package college.pj;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import college.net.NetProtocol;
import college.pj.dao.BoardDao;
import college.pj.dao.MemberDao;
import college.pj.dao.MySQLBoardDao;
import college.pj.dao.MySQLMemberDao;
import college.pj.handler.BoardAddListener;
import college.pj.handler.BoardDeleteListener;
import college.pj.handler.BoardDetailListener;
import college.pj.handler.BoardListListener;
import college.pj.handler.BoardUpdateListener;
import college.pj.handler.LoginListener;
import college.pj.handler.MemberAddListener;
import college.pj.handler.MemberDeleteListener;
import college.pj.handler.MemberDetailListener;
import college.pj.handler.MemberListListener;
import college.pj.handler.MemberUpdateListener;
import college.pj.util.BreadcrumbPrompt;
import college.pj.util.Menu;
import college.pj.util.MenuGroup;
import college.pj.util.SqlSessionFactoryProxy;

public class ServerApp {

  ExecutorService threadPool = Executors.newFixedThreadPool(2);

  SqlSessionFactory sqlSessionFactory;

  MemberDao memberDao;
  BoardDao boardDao;

  MenuGroup mainMenu = new MenuGroup("메인");

  int port;

  public ServerApp(int port) throws Exception {

    this.port = port;

    InputStream mybatisConfigIn = Resources.getResourceAsStream("college/pj/config/mybatis-config.xml");

    SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();

    sqlSessionFactory = new SqlSessionFactoryProxy(builder.build(mybatisConfigIn));

    this.memberDao = new MySQLMemberDao(sqlSessionFactory);
    this.boardDao = new MySQLBoardDao(sqlSessionFactory);

    prepareMenu();
  }

  public void close() throws Exception {

  }

  public static void main(String[] args) throws Exception {
    ServerApp app = new ServerApp(8888);
    app.execute();
    app.close();
  }

  public void execute() {
    try (ServerSocket serverSocket = new ServerSocket(this.port)) {
      System.out.println("서버 실행중...");

      while (true) {
        Socket socket = serverSocket.accept();
        threadPool.execute(() -> processRequest(socket));
      }
    } catch (Exception e) {
      System.out.println("서버 실행 오류!");
      e.printStackTrace();
    }
  }

  private void processRequest(Socket socket) {
    try (Socket s = socket;
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream())) {

      BreadcrumbPrompt prompt = new BreadcrumbPrompt(in, out);

      InetSocketAddress clientAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
      System.out.printf("%s 클라이언트 접속함!\n", clientAddress.getHostString());

      out.writeUTF("[ㅇㅇ대학교 커뮤니티 게시판]\n"
          +"------------------------------------------");

      new LoginListener(memberDao).service(prompt);

      mainMenu.execute(prompt);
      out.writeUTF(NetProtocol.NET_END);

    } catch (Exception e) {
      System.out.println("클라이언트 통신 오류!");
      e.printStackTrace();

    } finally {
      ((SqlSessionFactoryProxy) sqlSessionFactory).clean();
    }
  }

  private void prepareMenu() {
    MenuGroup memberMenu = new MenuGroup("회원");
    memberMenu.add(new Menu("등록", new MemberAddListener(memberDao, sqlSessionFactory)));
    memberMenu.add(new Menu("목록", new MemberListListener(memberDao)));
    memberMenu.add(new Menu("조회", new MemberDetailListener(memberDao)));
    memberMenu.add(new Menu("변경", new MemberUpdateListener(memberDao, sqlSessionFactory)));
    memberMenu.add(new Menu("삭제", new MemberDeleteListener(memberDao, sqlSessionFactory)));
    mainMenu.add(memberMenu);

    MenuGroup boardMenu = new MenuGroup("공지사항");
    boardMenu.add(new Menu("등록", new BoardAddListener(1, boardDao, sqlSessionFactory)));
    boardMenu.add(new Menu("목록", new BoardListListener(1, boardDao)));
    boardMenu.add(new Menu("조회", new BoardDetailListener(1, boardDao, sqlSessionFactory)));
    boardMenu.add(new Menu("변경", new BoardUpdateListener(1, boardDao, sqlSessionFactory)));
    boardMenu.add(new Menu("삭제", new BoardDeleteListener(1, boardDao, sqlSessionFactory)));
    mainMenu.add(boardMenu);

    MenuGroup recruitMenu = new MenuGroup("모집게시판");
    recruitMenu.add(new Menu("등록", new BoardAddListener(2, boardDao, sqlSessionFactory)));
    recruitMenu.add(new Menu("목록", new BoardListListener(2, boardDao)));
    recruitMenu.add(new Menu("조회", new BoardDetailListener(2, boardDao, sqlSessionFactory)));
    recruitMenu.add(new Menu("변경", new BoardUpdateListener(2, boardDao, sqlSessionFactory)));
    recruitMenu.add(new Menu("삭제", new BoardDeleteListener(2, boardDao, sqlSessionFactory)));
    mainMenu.add(recruitMenu);

    MenuGroup freeMenu = new MenuGroup("자유게시판");
    freeMenu.add(new Menu("등록", new BoardAddListener(3, boardDao, sqlSessionFactory)));
    freeMenu.add(new Menu("목록", new BoardListListener(3, boardDao)));
    freeMenu.add(new Menu("조회", new BoardDetailListener(3, boardDao, sqlSessionFactory)));
    freeMenu.add(new Menu("변경", new BoardUpdateListener(3, boardDao, sqlSessionFactory)));
    freeMenu.add(new Menu("삭제", new BoardDeleteListener(3, boardDao, sqlSessionFactory)));
    mainMenu.add(freeMenu);

    MenuGroup archiveMenu = new MenuGroup("자료실");
    archiveMenu.add(new Menu("등록", new BoardAddListener(4, boardDao, sqlSessionFactory)));
    archiveMenu.add(new Menu("목록", new BoardListListener(4, boardDao)));
    archiveMenu.add(new Menu("조회", new BoardDetailListener(4, boardDao, sqlSessionFactory)));
    archiveMenu.add(new Menu("변경", new BoardUpdateListener(4, boardDao, sqlSessionFactory)));
    archiveMenu.add(new Menu("삭제", new BoardDeleteListener(4, boardDao, sqlSessionFactory)));
    mainMenu.add(archiveMenu);
  }
}




























