package pj.handler;

import pj.dao.BatterBoardDao;
import pj.util.ActionListener;
import pj.util.BreadcrumbPrompt;
import pj.vo.BatterBoard;

public class BatterDetailListener implements ActionListener {

  BatterBoardDao batterBoardDao;

  public BatterDetailListener(BatterBoardDao batterBoardDao) {
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

    System.out.printf("선수 이름: %s\n", batterBoard.getName());
    System.out.printf("타율: %s\n", batterBoard.getBattingAvrg());
    System.out.printf("타점: %s\n", batterBoard.getRbi());
    System.out.printf("홈런: %s\n", batterBoard.getHomerun());
    System.out.printf("조회수: %s\n", batterBoard.getViewCount());
    System.out.printf("등록일: %tY-%1$tm-%1$td\n", batterBoard.getCreatedDate());
    batterBoard.setViewCount(batterBoard.getViewCount() + 1);
    batterBoardDao.update(batterBoard);
  }
}


