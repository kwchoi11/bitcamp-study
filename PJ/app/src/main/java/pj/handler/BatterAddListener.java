package pj.handler;

import pj.dao.BatterBoardDao;
import pj.util.ActionListener;
import pj.util.BreadcrumbPrompt;
import pj.vo.BatterBoard;

public class BatterAddListener implements ActionListener {

  BatterBoardDao batterBoardDao;

  public BatterAddListener(BatterBoardDao batterBoardDao) {
    this.batterBoardDao = batterBoardDao;
  }

  @Override
  public void service(BreadcrumbPrompt prompt) {
    BatterBoard batterBoard = new BatterBoard();
    batterBoard.setName(prompt.inputString("선수 이름: "));
    batterBoard.setBattingAvrg(prompt.inputString("타율: "));
    batterBoard.setRbi(prompt.inputString("타점: "));
    batterBoard.setHomerun(prompt.inputString("홈런: "));

    batterBoardDao.insert(batterBoard);
  }
}


