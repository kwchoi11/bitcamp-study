package pj.handler;

import java.util.List;
import pj.util.ActionListener;
import pj.vo.Board;

public abstract class AbstractBatterBoardListener implements ActionListener {

  protected List<Board> list;

  public AbstractBatterBoardListener(List<Board> list) {
    this.list = list;
  }

  protected Board findBy(int no) {
    for (int i = 0; i < this.list.size(); i++) {
      Board b = this.list.get(i);
      if (b.getNo() == no) {
        return b;
      }
    }
    return null;
  }

}
