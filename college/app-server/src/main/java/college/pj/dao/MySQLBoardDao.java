package college.pj.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import college.pj.vo.Board;

public class MySQLBoardDao implements BoardDao {

  SqlSessionFactory sqlSessionFactory;

  public MySQLBoardDao(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }

  @Override
  public void insert(Board board) {
    SqlSession sqlSession = sqlSessionFactory.openSession(false);
    sqlSession.insert("college.pj.dao.BoardDao.insert", board);
  }

  @Override
  public List<Board> findAll(int category) {
    SqlSession sqlSession = sqlSessionFactory.openSession(true);
    return sqlSession.selectList("college.pj.dao.BoardDao.findAll", category);
  }

  @Override
  public Board findBy(int category, int no) {
    SqlSession sqlSession = sqlSessionFactory.openSession(true);

    Map<String,Object> paramMap = new HashMap<>();
    paramMap.put("categoryNo", category);
    paramMap.put("boardNo", no);

    return sqlSession.selectOne("college.pj.dao.BoardDao.findBy", paramMap);
  }

  @Override
  public int update(Board board) {
    SqlSession sqlSession = sqlSessionFactory.openSession(false);
    return sqlSession.update("college.pj.dao.BoardDao.update", board);
  }

  @Override
  public int updateCount(Board board) {
    SqlSession sqlSession = sqlSessionFactory.openSession(false);
    return sqlSession.update("college.pj.dao.BoardDao.updateCount", board);
  }

  @Override
  public int delete(Board board) {
    SqlSession sqlSession = sqlSessionFactory.openSession(false);
    return sqlSession.delete("college.pj.dao.BoardDao.delete", board);
  }
}
