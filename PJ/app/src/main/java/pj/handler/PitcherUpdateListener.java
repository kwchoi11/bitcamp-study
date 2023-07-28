package pj.handler;

import pj.dao.PitcherBoardDao;
import pj.util.ActionListener;
import pj.util.BreadcrumbPrompt;
import pj.vo.PitcherBoard;

public class PitcherUpdateListener implements ActionListener {

  PitcherBoardDao pitcherBoardDao;

  public PitcherUpdateListener(PitcherBoardDao pitcherBoardDao) {
    this.pitcherBoardDao = pitcherBoardDao;
  }

  @Override
  public void service(BreadcrumbPrompt prompt) {
    int pitcherBoardNo = prompt.inputInt("번호: ");

    PitcherBoard pitcherBoard = pitcherBoardDao.findBy(pitcherBoardNo);
    if (pitcherBoard == null) {
      System.out.println("해당 번호의 선수 기록이 없습니다!");
      return;
    }

    pitcherBoard.setName(prompt.inputString("선수 이름(%s): ", pitcherBoard.getName()));
    pitcherBoard.setEra(prompt.inputString("평균자책점(%s): ", pitcherBoard.getEra()));
    pitcherBoard.setStrikeOut(prompt.inputString("탈삼진(%s): ", pitcherBoard.getStrikeOut()));
    pitcherBoard.setWhip(prompt.inputString("WHIP(%s): ", pitcherBoard.getWhip()));

    pitcherBoardDao.update(pitcherBoard);
  }
}
