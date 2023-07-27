package pj.dao;

import java.util.ArrayList;
import java.util.List;
import pj.util.JsonDataHelper;
import pj.vo.PitcherBoard;

public class PitcherBoardListDao implements PitcherBoardDao {
  String filename;
  ArrayList<PitcherBoard> list = new ArrayList<>();

  public PitcherBoardListDao(String filename) {
    this.filename = filename;
    JsonDataHelper.loadJson(filename, list, PitcherBoard.class);
  }

  @Override
  public void insert(PitcherBoard pitcherBoard) {
    pitcherBoard.setNo(PitcherBoard.pitcherBoardNo++);
    pitcherBoard.setCreatedDate(System.currentTimeMillis());
    this.list.add(pitcherBoard);
    JsonDataHelper.saveJson(filename, list);
  }

  @Override
  public List<PitcherBoard> list() {
    return this.list;
  }

  @Override
  public PitcherBoard findBy(int no) {
    for (int i = 0; i < this.list.size(); i++) {
      PitcherBoard m = this.list.get(i);
      if (m.getNo() == no) {
        return m;
      }
    }
    return null;
  }

  @Override
  public int update(PitcherBoard pitcherBoard) {
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).getNo() == pitcherBoard.getNo()) {
        list.set(i, pitcherBoard);
        JsonDataHelper.saveJson(filename, list);
        return 1;
      }
    }
    return 0;
  }

  @Override
  public int delete(int no) {
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).getNo() == no) {
        list.remove(i);
        JsonDataHelper.saveJson(filename, list);
        return 1;
      }
    }
    return 0;
  }
}
