package pj.handler;

import pj.dao.PitcherBoardDao;
import pj.util.ActionListener;
import pj.util.BreadcrumbPrompt;
import pj.vo.PitcherBoard;

public class PitcherAddListener implements ActionListener {

  PitcherBoardDao pitcherBoardDao;

  public PitcherAddListener(PitcherBoardDao pitcherBoardDao) {
    this.pitcherBoardDao = pitcherBoardDao;
  }

  @Override
  public void service(BreadcrumbPrompt prompt) {
    PitcherBoard pitcherBoard = new PitcherBoard();
    pitcherBoard.setName(prompt.inputString("선수 이름: "));
    pitcherBoard.setEra(prompt.inputString("평균자책점: "));
    pitcherBoard.setStrikeOut(prompt.inputString("탈삼진: "));
    pitcherBoard.setWhip(prompt.inputString("WHIP: "));

    pitcherBoardDao.insert(pitcherBoard);
  }
}


