package bitcamp.myapp.dao;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.List;
import bitcamp.myapp.vo.Board;

public class BoardNetworkDao implements BoardDao {

  String dataName;
  DataInputStream in;
  DataOutputStream out;

  public BoardNetworkDao(String dataName, DataInputStream in, DataOutputStream out) {

    this.dataName = dataName;
    this.in = in;
    this.out = out;
  }

  @Override
  public void insert(Board board) {

  }

  @Override
  public List<Board> list() {
    return null;
  }

  @Override
  public Board findBy(int no) {
    return null;
  }

  @Override
  public int update(Board board) {
    return 0;
  }

  @Override
  public int delete(int no) {
    return 0;
  }


}
