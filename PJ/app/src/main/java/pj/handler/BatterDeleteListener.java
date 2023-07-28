package pj.handler;

import pj.dao.BatterBoardDao;
import pj.util.ActionListener;
import pj.util.BreadcrumbPrompt;

public class BatterDeleteListener implements ActionListener {

  BatterBoardDao batterBoardDao;

  public BatterDeleteListener(BatterBoardDao batterBoardDao) {
    this.batterBoardDao = batterBoardDao;
  }

  @Override
  public void service(BreadcrumbPrompt prompt) {
    if (batterBoardDao.delete(prompt.inputInt("번호를 입력해주세요. ")) == 0) {
      System.out.println("해당 번호의 선수 기록이 없습니다!");
    }
  }
}


