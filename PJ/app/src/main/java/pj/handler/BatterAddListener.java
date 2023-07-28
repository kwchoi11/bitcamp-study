package pj.handler;

import pj.dao.BoardDao;
import pj.util.ActionListener;
import pj.util.BreadcrumbPrompt;
import pj.vo.BatterBoard;

public class BatterAddListener implements ActionListener {

  BoardDao boardDao;

  public BatterAddListener(BoardDao boardDao) {
    this.boardDao = boardDao;
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


