package pj.handler;

import pj.util.Prompt;
import pj.vo.Member;

public class MemberHandler {

  static final int MAX_SIZE = 100;
  static Member[] members = new Member[MAX_SIZE];
  static int userId = 1;
  static int length = 0;

  static final char CATCHER = 'C';
  static final char PITCHER = 'P';
  static final char OUTFIELDER = 'O';
  static final char INFIELDER = 'I';

  public static void inputMember() {
    if (!available()) {
      System.out.println("더이상 입력할 수 없습니다!");
      return;
    }

    Member m = new Member();
    m.name = Prompt.inputString("이름: ");
    m.dob = Prompt.inputString("생년월일: ");
    m.position = inputPosition((char) 0);
    m.strikeouts = Prompt.inputString("탈삼진: ");
    m.era = Prompt.inputString("평균자책점: ");
    m.hand = Prompt.inputString("투타: ");

    m.no = userId++;
    members[length++] = m;
  }

  public static void printMembers() {
    System.out.println("-------------------------------------------------------");
    System.out.println("번호, 이름, 생년월일, 포지션, 탈삼진, 평균자책점, 투/타");
    System.out.println("-------------------------------------------------------");

    for (int i = 0; i < length; i++) {
      Member m = members[i];
      System.out.printf("%d, %s, %s, %s, %s, %s, %s\n", m.no, m.name, m.dob,
          toPositionString(m.position), m.strikeouts, m.era, m.hand);
    }
  }

  public static void viewMember() {
    String memberNo = Prompt.inputString("등록 번호를 입력해주세요.");
    for (int i = 0; i < length; i++) {
      Member m = members[i];
      if (m.no == Integer.parseInt(memberNo)) {
        System.out.printf("이름: %s\n", m.name);
        System.out.printf("생년월일: %s\n", m.dob);
        System.out.printf("포지션: %s\n", toPositionString(m.position));
        System.out.printf("탈삼진: %s\n", m.strikeouts);
        System.out.printf("평균자책점: %s\n", m.era);
        System.out.printf("투타: %s\n", m.hand);
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

  public static void updateMember() {
    String memberNo = Prompt.inputString("등록 번호를 입력해주세요.");
    for (int i = 0; i < length; i++) {
      Member m = members[i];
      if (m.no == Integer.parseInt(memberNo)) {
        System.out.printf("이름(%s): ", m.name);
        m.name = Prompt.inputString("");
        System.out.printf("생년월일(%s): ", m.dob);
        m.dob = Prompt.inputString("");
        m.position = inputPosition(m.position);
        System.out.printf("탈삼진(%s): ", m.strikeouts);
        m.strikeouts = Prompt.inputString("");
        System.out.printf("평균자책점(%s): ", m.era);
        m.era = Prompt.inputString("");
        System.out.printf("투타(%s): ", m.hand);
        m.hand = Prompt.inputString("");
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
          return CATCHER;
        case "2":
          return PITCHER;
        case "3":
          return OUTFIELDER;
        case "4":
          return INFIELDER;
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
      if (m.no == memberNo) {
        return i;
      }
    }
    return -1;
  }



  public static boolean available() {
    return length < MAX_SIZE;
  }
}
