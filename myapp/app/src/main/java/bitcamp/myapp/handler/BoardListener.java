package bitcamp.myapp.handler;

import bitcamp.myapp.vo.Board;
import bitcamp.util.ActionListener;
import bitcamp.util.BreadcrumbPrompt;
import bitcamp.util.List;

public class BoardListener implements ActionListener {
  protected List list;

  public BoardListener(List list) {
    this.list = list;
  }

  protected Board findBy(int no) {
    for (int i = 0; i < this.list.size(); i++) {
      Board b = (Board) this.list.get(i);
      if (b.getNo() == no) {
        return b;
      }
    }
    return null;
  }

  @Override
  public void service(BreadcrumbPrompt prompt) {

  }

}
