package pj.handler;

import java.util.List;
import pj.util.BreadcrumbPrompt;
import pj.vo.PitcherBoard;

public class PitcherUpdateListener extends AbstractPitcherBoardListener {

  public PitcherUpdateListener(List<PitcherBoard> list) {
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

    // if (!prompt.inputString("암호? ").equals(pitcherBoard.getWhip())) {
    // System.out.println("암호가 일치하지 않습니다!");
    // return;
    // }

    pitcherBoard.setName(prompt.inputString("제목(%s)? ", pitcherBoard.getName()));
    pitcherBoard.setEra(prompt.inputString("내용(%s)? ", pitcherBoard.getEra()));
  }
}
