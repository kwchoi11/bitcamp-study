package bitcamp.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import bitcamp.myapp.dao.BoardDao;
import bitcamp.myapp.vo.Board;

public class MySQLBoardDao implements BoardDao {

  Connection con;

  public MySQLBoardDao(Connection con) {
    this.con = con;
  }

  @Override
  public void insert(Board board) {
    try (Statement stmt = con.createStatement()) {

      stmt.executeUpdate(String.format(
          "insert into myapp_board("
              + "title, content, writer, view_count, created_date, category) "
              + "values('%s', '%s', '%s', '%d', '%s', '%d')",
              board.getTitle(),
              board.getContent(),
              board.getWriter(),
              board.getViewCount(),
              board.getCreatedDate(),
              board.getCategory()));

    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public List<Board> list() {
    try (Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(
            "select board_no, "
                + "title, "
                + "content, "
                + "writer, "
                + "view_count, "
                + "created_date, "
                + "category "
                + "from myapp_board order by board_no desc")) {

      List<Board> list = new ArrayList<>();

      while (rs.next()) {
        Board board = new Board();
        board.setNo(rs.getInt("board_no"));
        board.setTitle(rs.getString("title"));
        board.setContent(rs.getString("content"));
        board.setWriter(rs.getString("writer"));
        board.setViewCount(rs.getInt("view_count"));
        board.setCreatedDate(rs.getString("created_date"));

        list.add(board);
      }

      return list;

    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public Board findBy(int no) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public int update(Board board) {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public int delete(int no) {
    // TODO Auto-generated method stub
    return 0;
  }

}
