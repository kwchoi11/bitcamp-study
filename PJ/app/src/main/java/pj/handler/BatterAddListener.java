package pj.handler;

import java.util.List;
import pj.util.BreadcrumbPrompt;
import pj.vo.BatterBoard;

public class BatterAddListener extends AbstractBatterBoardListener {

  public BatterAddListener(List<BatterBoard> list) {
    super(list);
  }

  @Override
  public void service(BreadcrumbPrompt prompt) {
    BatterBoard batterBoard = new BatterBoard();
    batterBoard.setName(prompt.inputString("선수 이름: "));
    batterBoard.setBattingAvrg(prompt.inputString("타율: "));
    batterBoard.setRbi(prompt.inputString("타점: "));
    batterBoard.setHomerun(prompt.inputString("홈런: "));
    this.list.add(batterBoard);
  }
}


