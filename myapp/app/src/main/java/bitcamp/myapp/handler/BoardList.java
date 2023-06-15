package bitcamp.myapp.handler;

import bitcamp.myapp.vo.Board;

public class BoardList {
  private static final int MAX_SIZE = 100;

  private Board[] boards = new Board[MAX_SIZE];
  private int length = 0;

  public boolean add(Board board) {
    if (!this.available()) {
      return false;
    }
    this.boards[this.length++] = board;
    return true;
  }

  public Board[] list() {
    Board[] arr = new Board[this.length];

    for (int i = 0; i < this.length; i++) {
      arr[i] = boards[i];
    }

    return arr;
  }

  private boolean available() {
    return this.length < MAX_SIZE;
  }
}
