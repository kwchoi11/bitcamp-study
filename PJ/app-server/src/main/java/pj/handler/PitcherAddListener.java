package pj.handler;

import java.util.List;
import pj.util.BreadcrumbPrompt;
import pj.vo.PitcherBoard;

public class PitcherAddListener extends AbstractPitcherBoardListener {

  public PitcherAddListener(List<PitcherBoard> list) {
    super(list);
  }

  @Override
  public void service(BreadcrumbPrompt prompt) {
    PitcherBoard pitcherBoard = new PitcherBoard();
    pitcherBoard.setName(prompt.inputString("선수 이름: "));
    pitcherBoard.setEra(prompt.inputString("평균자책점: "));
    pitcherBoard.setStrikeOut(prompt.inputString("탈삼진: "));
    pitcherBoard.setWhip(prompt.inputString("WHIP: "));
    this.list.add(pitcherBoard);
  }
}


