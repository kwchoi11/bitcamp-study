package pj.handler;

import pj.dao.BatterBoardDao;
import pj.util.ActionListener;
import pj.util.BreadcrumbPrompt;
import pj.vo.BatterBoard;

public class BatterUpdateListener implements ActionListener {

  BatterBoardDao batterBoardDao;

  public BatterUpdateListener(BatterBoardDao batterBoardDao) {
    this.batterBoardDao = batterBoardDao;
  }

  @Override
  public void service(BreadcrumbPrompt prompt) {
    int batterBoardNo = prompt.inputInt("번호: ");

    BatterBoard batterBoard = batterBoardDao.findBy(batterBoardNo);
    if (batterBoard == null) {
      System.out.println("해당 번호의 선수 기록이 없습니다!");
      return;
    }

    batterBoard.setName(prompt.inputString("선수 이름(%s): ", batterBoard.getName()));
    batterBoard.setBattingAvrg(prompt.inputString("타점(%s): ", batterBoard.getBattingAvrg()));
    batterBoard.setRbi(prompt.inputString("타율(%s): ", batterBoard.getRbi()));
    batterBoard.setHomerun(prompt.inputString("홈런(%s): ", batterBoard.getHomerun()));

    batterBoardDao.update(batterBoard);
  }
}
