package pj.handler;

import java.util.List;
import pj.util.BreadcrumbPrompt;
import pj.vo.PitcherBoard;

public class PitcherDeleteListener extends AbstractPitcherBoardListener {

  public PitcherDeleteListener(List<PitcherBoard> list) {
    super(list);
  }

  @Override
  public void service(BreadcrumbPrompt prompt) {
    if (!this.list.remove(new PitcherBoard(prompt.inputInt("번호를 입력해주세요. ")))) {
      System.out.println("해당 번호의 선수 기록이 없습니다!");
    }
  }
}


