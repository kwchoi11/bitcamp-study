package pj.handler;

import java.util.List;
import pj.dao.BatterBoardDao;
import pj.util.ActionListener;
import pj.util.BreadcrumbPrompt;
import pj.vo.BatterBoard;

public class BatterListListener implements ActionListener {

  BatterBoardDao batterBoardDao;

  public BatterListListener(BatterBoardDao batterBoardDao) {
    this.batterBoardDao = batterBoardDao;
  }

  @Override
  public void service(BreadcrumbPrompt prompt) {
    System.out.println("-------------------------------------------------");
    System.out.println("번호, 선수 이름, 타율, 타점, 홈런, 조회수, 등록일");
    System.out.println("-------------------------------------------------");

    List<BatterBoard> list = batterBoardDao.list();

    for (BatterBoard batterBoard : list ) {
      System.out.printf("%d, %s, %s, %s, %s, %d, %tY-%7$tm-%7$td\n",
          batterBoard.getNo(),
          batterBoard.getName(),
          batterBoard.getBattingAvrg(),
          batterBoard.getRbi(),
          batterBoard.getHomerun(),
          batterBoard.getViewCount(),
          batterBoard.getCreatedDate());
    }
  }
}


