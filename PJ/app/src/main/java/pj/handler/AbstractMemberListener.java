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

}
