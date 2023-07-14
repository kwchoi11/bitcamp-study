package pj.handler;

import pj.util.Prompt;
import pj.vo.Member;

public class MemberHandler {

  private static final int MAX_SIZE = 100;

  private Prompt prompt;

  private Member[] members = new Member[MAX_SIZE];

  private int length;

  public MemberHandler(Prompt prompt) {
    this.prompt = prompt;
  }

  public void inputMember() {
    if (!this.available()) {
      System.out.println("더이상 입력할 수 없습니다!");
      return;
    }

    Member m = new Member();
    m.setName(this.prompt.inputString("이름: "));
    m.setDob(this.prompt.inputString("생년월일: "));
    m.setPosition(inputPosition((char) 0));
    m.setStrikeouts(this.prompt.inputString("탈삼진(투수): "));
    m.setHomerun(this.prompt.inputString("홈런(타자): "));
    m.setHand(inputHand("0"));

    this.members[this.length++] = m;
  }

  public void printMembers() {
    System.out.println("-------------------------------------------------------------");
    System.out.println("번호, 이름, 생년월일, 포지션, 탈삼진(투수), 홈런(타자), 투/타");
    System.out.println("-------------------------------------------------------------");

    for (int i = 0; i < length; i++) {
      Member m = this.members[i];
      System.out.printf("%d, %s, %s, %s, %s, %s, %s\n", m.getNo(), m.getName(), m.getDob(),
          toPositionString(m.getPosition()), m.getStrikeouts(), m.getHomerun(),
          toHandString(m.getHand()));
    }
  }

  public void viewMember() {
    String memberNo = this.prompt.inputString("등록 번호를 입력해주세요.");
    for (int i = 0; i < this.length; i++) {
      Member m = this.members[i];
      if (m.getNo() == Integer.parseInt(memberNo)) {
        System.out.printf("이름: %s\n", m.getName());
        System.out.printf("생년월일: %s\n", m.getDob());
        System.out.printf("포지션: %s\n", toPositionString(m.getPosition()));
        System.out.printf("탈삼진(투수): %s\n", m.getStrikeouts());
        System.out.printf("홈런(타자): %s\n", m.getHomerun());
        System.out.printf("투타: %s\n", toHandString(m.getHand()));
        return;
      }
    }
    System.out.println("해당 번호로 등록된 선수가 없습니다.");
  }

  public static String toPositionString(char position) {
    if (position == 'C') {
      return "포수";
    } else if (position == 'P') {
      return "투수";
    } else if (position == 'O') {
      return "외야수";
    } else if (position == 'I') {
      return "내야수";
    }
    throw new IllegalArgumentException("유효하지 않은 포지션입니다.");
  }

  public static String toHandString(String hand) {
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

  public void updateMember() {
    String memberNo = this.prompt.inputString("등록 번호를 입력해주세요.");
    for (int i = 0; i < this.length; i++) {
      Member m = this.members[i];
      if (m.getNo() == Integer.parseInt(memberNo)) {
        System.out.printf("이름(%s): ", m.getName());
        m.setName(Prompt.inputString(""));
        System.out.printf("생년월일(%s): ", m.getDob());
        m.setDob(Prompt.inputString(""));
        m.setPosition(inputPosition(m.getPosition()));
        System.out.printf("탈삼진(투수)(%s): ", m.getStrikeouts());
        m.setStrikeouts(Prompt.inputString(""));
        System.out.printf("홈런(타자)(%s): ", m.getHomerun());
        m.setHomerun(Prompt.inputString(""));
        m.setHand(inputHand(m.getHand()));
        return;
      }
    }
    System.out.println("해당 번호로 등록된 선수가 없습니다.");
  }

  private char inputPosition(char position) {
    String label;
    if (position == 0) {
      label = "포지션:\n";
    } else {
      label = String.format("포지션(%s):\n", toPositionString(position));
    }

    while (true) {
      String menuNo = Prompt
          .inputString(label + "  1. 포수\n" + "  2. 투수\n" + "  3. 외야수\n" + "  4. 내야수\n" + "> ");

      switch (menuNo) {
        case "1":
          return Member.CATCHER;
        case "2":
          return Member.PITCHER;
        case "3":
          return Member.OUTFIELDER;
        case "4":
          return Member.INFIELDER;
        default:
          System.out.println("무효한 번호입니다.");
      }
    }
  }

  private static String inputHand(String hand) {
    String label;
    if (hand.equals("0")) {
      label = "투타:\n";
    } else {
      label = String.format("투타(%s):\n", toHandString(hand));
    }

    while (true) {
      String menuNo2 = Prompt.inputString(
          label + "  1. 우투우타\n" + "  2. 우투좌타\n" + "  3. 좌투좌타\n" + "  4. 좌투우타\n" + "> ");

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

  public void deleteMember() {
    int memberNo = this.prompt.inputInt("등록 번호를 입력해주세요.");

    int deletedIndex = indexOf(memberNo);
    if (deletedIndex == -1) {
      System.out.println("해당 번호로 등록된 선수가 없습니다.");
      return;
    }

    for (int i = deletedIndex; i < this.length - 1; i++) {
      this.members[i] = this.members[i + 1];
    }

    this.members[--this.length] = null;
  }

  private int indexOf(int memberNo) {
    for (int i = 0; i < this.length; i++) {
      Member m = this.members[i];
      if (m.getNo() == memberNo) {
        return i;
      }
    }
    return -1;
  }

  private boolean available() {
    return this.length < MAX_SIZE;
  }
}
