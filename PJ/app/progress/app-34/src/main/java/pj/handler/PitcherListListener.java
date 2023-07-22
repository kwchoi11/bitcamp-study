package pj.handler;

import java.util.Iterator;
import java.util.List;
import pj.util.BreadcrumbPrompt;
import pj.vo.PitcherBoard;

public class PitcherListListener extends AbstractPitcherBoardListener {

  public PitcherListListener(List<PitcherBoard> list) {
    super(list);
  }

  @Override
  public void service(BreadcrumbPrompt prompt) {
    System.out.println(
        "----------------------------------------------------------------------------------");
    System.out.println("번호, 선수 이름, 평균자책점, 탈삼진, WHIP(이닝당 볼넷+안타 허용률), 조회수, 등록일");
    System.out.println(
        "----------------------------------------------------------------------------------");

    Iterator<PitcherBoard> iterator = list.iterator();

    while (iterator.hasNext()) {
      PitcherBoard pitcherBoard = iterator.next();
      System.out.printf("%d, %s, %s, %s, %s, %d, %tY-%7$tm-%7$td\n", pitcherBoard.getNo(),
          pitcherBoard.getName(), pitcherBoard.getEra(), pitcherBoard.getStrikeOut(),
          pitcherBoard.getWhip(), pitcherBoard.getViewCount(), pitcherBoard.getCreatedDate());
    }
  }
}


