package pj.handler;

import java.util.List;
import pj.util.ActionListener;
import pj.vo.BatterBoard;

public abstract class AbstractBatterBoardListener implements ActionListener {

  protected List<BatterBoard> list;

  public AbstractBatterBoardListener(List<BatterBoard> list) {
    this.list = list;
  }

  protected BatterBoard findBy(int no) {
    for (int i = 0; i < this.list.size(); i++) {
      BatterBoard b = this.list.get(i);
      if (b.getNo() == no) {
        return b;
      }
    }
    return null;
  }

}
