package pj.handler;

import pj.util.Prompt;
import pj.vo.Member;

public class MemberHandler {

  static final int MAX_SIZE = 100;
  static Member[] members = new Member[MAX_SIZE];
  static int length = 0;

  public static void inputMember() {
    if (!available()) {
      System.out.println("더이상 입력할 수 없습니다!");
      return;
    }

    Member m = new Member();
    m.name = Prompt.inputString("이름: ");
    m.dob = Prompt.inputString("생년월일: ");
    m.position = inputPosition((char) 0);
    m.strikeouts = Prompt.inputString("탈삼진(투수): ");
    m.homerun = Prompt.inputString("홈런(타자): ");
    m.hand = inputHand("0");

    members[length++] = m;
  }

  public static void printMembers() {
    System.out.println("-------------------------------------------------------------");
    System.out.println("번호, 이름, 생년월일, 포지션, 탈삼진(투수), 홈런(타자), 투/타");
    System.out.println("-------------------------------------------------------------");

    for (int i = 0; i < length; i++) {
      Member m = members[i];
      System.out.printf("%d, %s, %s, %s, %s, %s, %s\n", m.getNo(), m.getName(), m.getDob(),
          toPositionString(m.getPosition()), m.getStrikeouts(), m.getHomerun(),
          toHandString(m.getHand()));
    }
  }

  public static void viewMember() {
    String memberNo = Prompt.inputString("등록 번호를 입력해주세요.");
    for (int i = 0; i < length; i++) {
      Member m = members[i];
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

  public static void updateMember() {
    String memberNo = Prompt.inputString("등록 번호를 입력해주세요.");
    for (int i = 0; i < length; i++) {
      Member m = members[i];
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

  private static char inputPosition(char position) {
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

  public static void deleteMember() {
    int memberNo = Prompt.inputInt("등록 번호를 입력해주세요.");

    int deletedIndex = indexOf(memberNo);
    if (deletedIndex == -1) {
      System.out.println("해당 번호로 등록된 선수가 없습니다.");
      return;
    }

    for (int i = deletedIndex; i < length - 1; i++) {
      members[i] = members[i + 1];
    }

    members[--length] = null;
  }

  private static int indexOf(int memberNo) {
    for (int i = 0; i < length; i++) {
      Member m = members[i];
      if (m.getNo() == memberNo) {
        return i;
      }
    }
    return -1;
  }

  public static boolean available() {
    return length < MAX_SIZE;
  }
}
