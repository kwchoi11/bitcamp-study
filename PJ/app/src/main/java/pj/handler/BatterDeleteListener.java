package pj.handler;

import java.util.List;
import pj.util.BreadcrumbPrompt;
import pj.vo.BatterBoard;

public class BatterDeleteListener extends AbstractBatterBoardListener {

  public BatterDeleteListener(List<BatterBoard> list) {
    super(list);
  }

  @Override
  public void service(BreadcrumbPrompt prompt) {
    if (!this.list.remove(new BatterBoard(prompt.inputInt("번호를 입력해주세요. ")))) {
      System.out.println("해당 번호의 선수 기록이 없습니다!");
    }
  }
}


