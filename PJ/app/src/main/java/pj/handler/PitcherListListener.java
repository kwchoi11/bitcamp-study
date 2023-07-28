package pj.handler;

import java.util.List;
import pj.dao.PitcherBoardDao;
import pj.util.ActionListener;
import pj.util.BreadcrumbPrompt;
import pj.vo.PitcherBoard;

public class PitcherListListener implements ActionListener {

  PitcherBoardDao pitcherBoardDao;

  public PitcherListListener(PitcherBoardDao pitcherBoardDao) {
    this.pitcherBoardDao = pitcherBoardDao;
  }

  @Override
  public void service(BreadcrumbPrompt prompt) {
    System.out.println(
        "----------------------------------------------------------------------------------");
    System.out.println("번호, 선수 이름, 평균자책점, 탈삼진, WHIP(이닝당 볼넷+안타 허용률), 조회수, 등록일");
    System.out.println(
        "----------------------------------------------------------------------------------");

    List<PitcherBoard> list = pitcherBoardDao.list();

    for (PitcherBoard pitcherBoard : list) {
      System.out.printf("%d, %s, %s, %s, %s, %d, %tY-%7$tm-%7$td\n",
          pitcherBoard.getNo(),
          pitcherBoard.getName(),
          pitcherBoard.getEra(),
          pitcherBoard.getStrikeOut(),
          pitcherBoard.getWhip(),
          pitcherBoard.getViewCount(),
          pitcherBoard.getCreatedDate());
    }
  }
}


