package pj.handler;

import pj.util.Prompt;

public class MemberHandler {

  static final int MAX_SIZE = 100;
  static int[] no = new int[MAX_SIZE];
  static String[] name = new String[MAX_SIZE];
  static String[] dob = new String[MAX_SIZE];
  static char[] position = new char[MAX_SIZE];
  static String[] strikeouts = new String[MAX_SIZE];
  static String[] era = new String[MAX_SIZE];
  static String[] hand = new String[MAX_SIZE];
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

    name[length] = Prompt.inputString("이름: ");
    dob[length] = Prompt.inputString("생년월일: ");
    position[length] = inputPosition((char) 0);
    strikeouts[length] = Prompt.inputString("탈삼진: ");
    era[length] = Prompt.inputString("평균자책점: ");
    hand[length] = Prompt.inputString("투타: ");

    no[length] = userId++;
    length++;
  }

  public static void printMembers() {
    System.out.println("-------------------------------------------------------");
    System.out.println("번호, 이름, 생년월일, 포지션, 탈삼진, 평균자책점, 투/타");
    System.out.println("-------------------------------------------------------");

    for (int i = 0; i < length; i++) {
      System.out.printf("%d, %s, %s, %s, %s, %s, %s\n", no[i], name[i], dob[i],
          toPositionString(position[i]), strikeouts[i], era[i], hand[i]);
    }
  }

  public static void viewMember() {
    String memberNo = Prompt.inputString("등록 번호를 입력해주세요.");
    for (int i = 0; i < length; i++) {
      if (no[i] == Integer.parseInt(memberNo)) {
        System.out.printf("이름: %s\n", name[i]);
        System.out.printf("생년월일: %s\n", dob[i]);
        System.out.printf("포지션: %s\n", toPositionString(position[i]));
        System.out.printf("탈삼진: %s\n", strikeouts[i]);
        System.out.printf("평균자책점: %s\n", era[i]);
        System.out.printf("투타: %s\n", hand[i]);
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
      if (no[i] == Integer.parseInt(memberNo)) {
        System.out.printf("이름(%s): ", name[i]);
        name[i] = Prompt.inputString("");
        System.out.printf("생년월일(%s): ", dob[i]);
        dob[i] = Prompt.inputString("");
        position[i] = inputPosition(position[i]);
        System.out.printf("탈삼진(%s): ", strikeouts[i]);
        strikeouts[i] = Prompt.inputString("");
        System.out.printf("평균자책점(%s): ", era[i]);
        era[i] = Prompt.inputString("");
        System.out.printf("투타(%s): ", hand[i]);
        hand[i] = Prompt.inputString("");
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
      no[i] = no[i + 1];
      name[i] = name[i + 1];
      dob[i] = dob[i + 1];
      position[i] = position[i + 1];
      strikeouts[i] = strikeouts[i + 1];
      era[i] = era[i + 1];
      hand[i] = hand[i + 1];
    }

    no[length - 1] = 0;
    name[length - 1] = null;
    dob[length - 1] = null;
    position[length - 1] = (char) 0;
    strikeouts[length - 1] = null;
    era[length - 1] = null;
    hand[length - 1] = null;

    length--;
  }

  private static int indexOf(int memberNo) {
    for (int i = 0; i < length; i++) {
      if (no[i] == memberNo) {
        return i;
      }
    }
    return -1;
  }



  public static boolean available() {
    return length < MAX_SIZE;
  }
}
