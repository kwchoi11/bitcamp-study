package pj.handler;

import java.util.List;
import pj.util.BreadcrumbPrompt;
import pj.vo.PitcherBoard;

public class PitcherDetailListener extends AbstractPitcherBoardListener {

  public PitcherDetailListener(List<PitcherBoard> list) {
    super(list);
  }

  @Override
  public void service(BreadcrumbPrompt prompt) {
    int pitcherBoardNo = prompt.inputInt("번호: ");

    PitcherBoard pitcherBoard = this.findBy(pitcherBoardNo);
    if (pitcherBoard == null) {
      System.out.println("해당 번호의 선수 기록이 없습니다!");
      return;
    }

    System.out.printf("선수 이름: %s\n", pitcherBoard.getName());
    System.out.printf("평균자책점: %s\n", pitcherBoard.getEra());
    System.out.printf("탈삼진: %s\n", pitcherBoard.getStrikeOut());
    System.out.printf("WHIP: %s\n", pitcherBoard.getWhip());
    System.out.printf("조회수: %s\n", pitcherBoard.getViewCount());
    System.out.printf("등록일: %tY-%1$tm-%1$td\n", pitcherBoard.getCreatedDate());
    pitcherBoard.setViewCount(pitcherBoard.getViewCount() + 1);
  }
}


