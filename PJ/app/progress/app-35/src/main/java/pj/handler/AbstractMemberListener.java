package pj.handler;

import java.util.List;
import pj.util.ActionListener;
import pj.util.BreadcrumbPrompt;
import pj.vo.Member;

public abstract class AbstractMemberListener implements ActionListener {

  protected List<Member> list;

  public AbstractMemberListener(List<Member> list) {
    this.list = list;
  }

  protected static String toPositionString(char position) {
    if (position == 'C') {
      return "포수";
    } else if (position == 'P') {
      return "투수";
    } else if (position == 'I') {
      return "내야수";
    } else if (position == 'O') {
      return "외야수";
    }
    throw new IllegalArgumentException("유효하지 않은 포지션입니다.");
  }

  protected static String toHandString(String hand) {
    if (hand.equals("RR")) {
      return "우투우타";
    } else if (hand.equals("RL")) {
      return "우투좌타";
    } else if (hand.equals("LL")) {
      return "좌투좌타";
    } else if (hand.equals("LR")) {
      return "좌투우타";
    }
    throw new IllegalArgumentException("다시 선택해주세요.");
  }

  protected Member findBy(int no) {
    for (int i = 0; i < this.list.size(); i++) {
      Member m = this.list.get(i);
      if (m.getNo() == no) {
        return m;
      }
    }
    return null;
  }

  protected char inputPosition(char position, BreadcrumbPrompt prompt) {
    String label;
    if (position == 0) {
      label = "포지션: \n";
    } else {
      label = String.format("포지션(%s): \n", toPositionString(position));
    }

    while (true) {
      String menuNo = prompt
          .inputString(label + "  1. 포수\n" + "  2. 투수\n" + "  3. 내야수\n" + "  4. 외야수\n" + "> ");

      switch (menuNo) {
        case "1":
          return Member.CATCHER;
        case "2":
          return Member.PITCHER;
        case "3":
          return Member.INFIELDER;
        case "4":
          return Member.OUTFIELDER;
        default:
          System.out.println("무효한 번호입니다. 다시 선택해주세요.");
      }
    }
  }

  protected String inputHand(String hand, BreadcrumbPrompt prompt) {
    String label;
    if (hand.equals("0")) {
      label = "투타:\n";
    } else {
      label = String.format("투타(%s):\n", toHandString(hand));
    }

    while (true) {
      String menuNo2 = this.prompt.inputString(label +
          "  1. 우투우타\n" +
          "  2. 우투좌타\n" +
          "  3. 좌투좌타\n" +
          "  4. 좌투우타\n" +
          "> ");

      switch (menuNo2) {
        case "1":
          return Member.RR;
        case "2":
          return Member.RL;
        case "3":
          return Member.LL;
        case "4":
          return Member.LR;
        default:
          System.out.println("무효한 번호입니다.");
      }
    }
  }

}
