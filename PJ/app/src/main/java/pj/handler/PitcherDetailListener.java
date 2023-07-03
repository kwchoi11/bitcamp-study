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

    PitcherBoard pitcherboard = this.findBy(pitcherBoardNo);
    if (pitcherboard == null) {
      System.out.println("해당 번호의 선수 기록이 없습니다!");
      return;
    }

    System.out.printf("선수 이름: %s\n", pitcherboard.getName());
    System.out.printf("평균자책점: %s\n", pitcherboard.getEra());
    System.out.printf("탈삼진: %s\n", pitcherboard.getStrikeOut());
    System.out.printf("WHIP: %s\n", pitcherboard.getWhip());
    System.out.printf("등록일: %tY-%1$tm-%1$td\n", pitcherboard.getCreatedDate());
    pitcherboard.setViewCount(pitcherboard.getViewCount() + 1);
  }
}


