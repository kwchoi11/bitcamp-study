package pj.dao;

import java.util.List;
import pj.vo.BatterBoard;

public interface BatterBoardDao {
  void insert(BatterBoard batterBoard);
  List<BatterBoard> list();
  BatterBoard findBy(int no);
  int update(BatterBoard batterBoard);
  int delete(BatterBoard batterBoard);
}
