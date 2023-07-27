package pj.dao;

import java.util.List;
import pj.vo.PitcherBoard;

public interface PitcherBoardDao {
  void insert(PitcherBoard pitcherBoard);
  List<PitcherBoard> list();
  PitcherBoard findBy(int no);
  int update(PitcherBoard pitcherBoard);
  int delete(PitcherBoard pitcherBoard);
}
