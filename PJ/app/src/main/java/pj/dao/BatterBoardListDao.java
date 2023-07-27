package pj.dao;

import java.util.ArrayList;
import java.util.List;
import pj.util.JsonDataHelper;
import pj.vo.BatterBoard;
import pj.vo.Board;

public class BatterBoardListDao implements BatterBoardDao {
  String filename;
  ArrayList<Board> list = new ArrayList<>();

  public BatterBoardListDao(String filename) {
    this.filename = filename;
    JsonDataHelper.loadJson(filename, list, BatterBoard.class);
  }

  @Override
  public void insert(BatterBoard batterBoard) {
    batterBoard.setNo(BatterBoard.batterBoardNo++);
    batterBoard.setCreatedDate(System.currentTimeMillis());
    this.list.add(batterBoard);
    JsonDataHelper.saveJson(filename, list);
  }

  @Override
  public List<BatterBoard> list() {
    return this.list;
  }

  @Override
  public BatterBoard findBy(int no) {
    for (int i = 0; i < this.list.size(); i++) {
      BatterBoard m = this.list.get(i);
      if (m.getNo() == no) {
        return m;
      }
    }
    return null;
  }

  @Override
  public int update(BatterBoard batterBoard) {
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).getNo() == batterBoard.getNo()) {
        list.set(i, batterBoard);
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
