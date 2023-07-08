package pj.handler;

import java.util.List;
import pj.util.ActionListener;
import pj.vo.PitcherBoard;

public abstract class AbstractPitcherBoardListener implements ActionListener {

  protected List<PitcherBoard> list;

  public AbstractPitcherBoardListener(List<PitcherBoard> list) {
    this.list = list;
  }

  protected PitcherBoard findBy(int no) {
    for (int i = 0; i < this.list.size(); i++) {
      PitcherBoard b = this.list.get(i);
      if (b.getNo() == no) {
        return b;
      }
    }
    return null;
  }

}
