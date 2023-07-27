package bitcamp.myapp.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import bitcamp.myapp.vo.Board;
import bitcamp.myapp.vo.Member;
import bitcamp.util.DataSource;

public class MySQLBoardDao implements BoardDao {

  SqlSessionFactory sqlSessionFactory;
  DataSource ds;
  int category;

  public MySQLBoardDao(SqlSessionFactory sqlSessionFactory, DataSource ds, int category) {
    this.sqlSessionFactory = sqlSessionFactory;
    this.ds = ds;
    this.category = category;
  }

  @Override
  public void insert(Board board) {
    board.setCategory(this.category);
    SqlSession sqlSession = sqlSessionFactory.openSession(false);
    sqlSession.insert("bitcamp.myapp.dao.BoardDao.insert", board);
  }

  @Override
  public List<Board> findAll() {
    SqlSession sqlSession = sqlSessionFactory.openSession(true);
    return sqlSession.selectList("bitcamp.myapp.dao.BoardDao.findAll", this.category);
  }

  @Override
  public Board findBy(int no) {
    try (PreparedStatement stmt = ds.getConnection(false).prepareStatement(
        "select" +
            "  b.board_no, " +
            "  b.title, " +
            "  b.content," +
            "  b.view_count, " +
            "  b.created_date, " +
            "  m.member_no, " +
            "  m.name " +
            " from " +
            "  myapp_board b inner join myapp_member m on b.writer=m.member_no" +
            " where " +
            "  category=?" +
            "  and board_no=?"
        )) {

      stmt.setInt(1, this.category);
      stmt.setInt(2, no);

      try (ResultSet rs = stmt.executeQuery()) {
        if (rs.next()) {
          Board b = new Board();
          b.setNo(rs.getInt("board_no"));
          b.setTitle(rs.getString("title"));
          b.setContent(rs.getString("content"));
          b.setViewCount(rs.getInt("view_count"));
          b.setCreatedDate(rs.getTimestamp("created_date"));

          Member writer = new Member();
          writer.setNo(rs.getInt("member_no"));
          writer.setName(rs.getString("name"));
          b.setWriter(writer);

          stmt.executeUpdate("update myapp_board set"
              + " view_count=view_count + 1"
              + " where board_no=" + no);

          return b;
        }
        return null;
      }
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public int update(Board board) {
    try (PreparedStatement stmt = ds.getConnection(false).prepareStatement(
        "update myapp_board set"
            + " title=?,"
            + " content=?"
            + " where category=? and board_no=? and writer=?")) {

      stmt.setString(1, board.getTitle());
      stmt.setString(2, board.getContent());
      stmt.setInt(3, this.category);
      stmt.setInt(4, board.getNo());
      stmt.setInt(5, board.getWriter().getNo());

      return stmt.executeUpdate();

    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public int delete(Board board) {
    try (PreparedStatement stmt = ds.getConnection(false).prepareStatement(
        "delete from myapp_board"
            + " where category=? and board_no=? and writer=?")) {

      stmt.setInt(1, this.category);
      stmt.setInt(2, board.getNo());
      stmt.setInt(3, board.getWriter().getNo());

      return stmt.executeUpdate();

    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

}
