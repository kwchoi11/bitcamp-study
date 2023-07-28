package pj.handler;

import pj.dao.PitcherBoardDao;
import pj.util.ActionListener;
import pj.util.BreadcrumbPrompt;

public class PitcherDeleteListener implements ActionListener {

  PitcherBoardDao pitcherBoardDao;

  public PitcherDeleteListener(PitcherBoardDao pitcherBoardDao) {
    this.pitcherBoardDao = pitcherBoardDao;
  }

  @Override
  public void service(BreadcrumbPrompt prompt) {
    if (pitcherBoardDao.delete(prompt.inputInt("번호를 입력해주세요. ")) == 0) {
      System.out.println("해당 번호의 선수 기록이 없습니다!");
    }
  }
}


