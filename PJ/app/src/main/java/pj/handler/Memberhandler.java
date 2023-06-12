package pj.handler;

import pj.util.Prompt;
import pj.vo.Member;

public class Memberhandler {

  static final int MAX_SIZE = 100;
  static Member[] members = new Member[MAX_SIZE];
  // static int userId = 1;
  static int length = 0;


  public static void inputMember() {
    if (!available()) {
      System.out.println("더 이상 입력할 수 없습니다.");
      return;
    }

    Member m = new Member();
    m.setName(Prompt.inputString("선수 이름을 입력하세요.\n"));
    m.setPosition(inputPosition((char) 0));
    m.setStrikeOuts(Prompt.inputString("선수의 탈삼진을 입력하세요. (투수)\n"));
    m.setHomeRuns(Prompt.inputString("선수의 홈런 수를 입력하세요. (타자)\n"));
    m.setHand(inputHand((char) 0));
    // m.no = userId++;

    // 위에서 만든 Member 인스턴스의 주소를 잃어버리지 않게
    // 레퍼런스 배열에 담는다.
    members[length++] = m;
  }

  public static void printMember() {
    System.out.println("============================================================");
    System.out.println("번호, 이름, 포지션, 탈삼진(투수), 홈런 수(타자), 주 사용 손");
    System.out.println("============================================================");

    for (int i = 0; i < length; i++) {
      Member m = members[i];
      System.out.printf("%d, %s, %s, %s, %s, %s\n", m.getNo(), m.getName(),
          toPositionString(m.getPosition()), m.getStrikeOuts(), m.getHomeRuns(),
          toHandString(m.getHand()));
    }
  }

  public static void viewMember() {
    String memberNo = Prompt.inputString("등록 번호를 입력해주세요.");
    for (int i = 0; i < length; i++) {
      Member m = members[i];
      if (m.getNo() == Integer.parseInt(memberNo)) {
        System.out.printf("이름: %s\n", m.getName());
        System.out.printf("포지션: %s\n", toPositionString(m.getPosition()));
        System.out.printf("탈삼진(투수): %s\n", m.getStrikeOuts());
        System.out.printf("홈런 수(타자): %s\n", m.getHomeRuns());
        System.out.printf("주 사용 손: %s\n", toHandString(m.getHand()));
        return;
      }
    }
    System.out.println("해당 번호의 선수가 없습니다.");
  }

  public static String toPositionString(char position) {
    return position == 'P' ? "투수" : "타자";
  }

  public static String toHandString(char hand) {
    return hand == 'L' ? "좌완(타)" : "우완(타)";
  }

  public static void updateMember() {
    String memberNo = Prompt.inputString("등록 번호를 입력해주세요.");
    for (int i = 0; i < length; i++) {
      Member m = members[i];
      if (m.getNo() == Integer.parseInt(memberNo)) {
        System.out.printf("이름(%s): ", m.getName());
        m.setName(Prompt.inputString(""));
        m.setPosition(inputPosition(m.getPosition()));
        System.out.printf("탈삼진(투수)(%s): ", m.getStrikeOuts());
        m.setStrikeOuts(Prompt.inputString(""));
        System.out.printf("홈런 수(타자)(%s): ", m.getHomeRuns());
        m.setHomeRuns(Prompt.inputString(""));
        m.setHand(inputHand(m.getHand()));
        return;
      }
    }
    System.out.println("해당 번호의 선수가 없습니다.");
  }


  private static char inputPosition(char position) {
    String label;
    if (position == 0) {
      label = "포지션을 입력하세요\n";
    } else {
      label = String.format("포지션을 입력하세요(%s).\n", toPositionString(position));
    }
    while (true) {
      String menuNo = Prompt.inputString(label + " 1. 투수\n" + " 2. 타자\n" + "> ");

      switch (menuNo) {
        case "1":
          return Member.PITCHER;
        case "2":
          return Member.BATTER;
        default:
          System.out.println("무효한 번호입니다.");
      }
    }
  }


  private static char inputHand(char hand) {
    String label;
    if (hand == 0) {
      label = "좌완(타)/우완(타)\n";
    } else {
      label = String.format("좌완(타)/우완(타)(%s)\n", toHandString(hand));
    }
    loop: while (true) {
      String menuNo = Prompt.inputString(label + " 1. 좌완(타)\n" + " 2. 우완(타)\n" + "> ");

      switch (menuNo) {
        case "1":
          return LEFT;
        case "2":
          return RIGHT;
        default:
          System.out.println("무효한 번호입니다.");
      }
    }
  }

  public static void deleteMember() {
    int memberNo = Prompt.inputInt("등록 번호를 입력해주세요.");

    int deletedIndex = indexOf(memberNo);
    if (deletedIndex == -1) {
      System.out.println("해당 번호의 선수가 없습니다.");
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
      if (m.no == memberNo) {
        return i;
      }
    }
    return -1;
  }

  private static boolean available() {
    return length < MAX_SIZE;
  }
}
