package pj.dao;

import java.util.List;
import pj.vo.Board;

public interface BoardDao {
  void insert(Board board);
  List<Board> list();
  Board findBy(int no);
  int update(Board board);
  int delete(int no);
}
