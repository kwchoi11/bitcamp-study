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
    name[length] = Prompt.inputString("이름: ");
    dob[length] = Prompt.inputString("생년월일: ");

    loop: while (true) {
      String menuNo = Prompt
          .inputString("포지션:\n" + "  1. 포수\n" + "  2. 투수\n" + "  3. 외야수\n" + "  4. 내야수\n" + "> ");

      switch (menuNo) {
        case "1":
          position[length] = CATCHER;
          break loop;
        case "2":
          position[length] = PITCHER;
          break loop;
        case "3":
          position[length] = OUTFIELDER;
          break loop;
        case "4":
          position[length] = INFIELDER;
          break loop;
        default:
          System.out.println("무효한 번호입니다.");
      }
    }

    strikeouts[length] = Prompt.inputString("탈삼진: ");
    era[length] = Prompt.inputString("평균자책점: ");
    hand[length] = Prompt.inputString("투타: ");

    no[length] = userId++;
    length++;
  }

  public static void printMembers() {
    System.out.println("------------------------------------------------------");
    System.out.println("번호, 이름, 생년월일, 포지션, 탈삼진, 평균자책점, 투타");
    System.out.println("------------------------------------------------------");

    for (int i = 0; i < length; i++) {
      System.out.printf("%d, %s, %s, %c, %s, %s, %s\n", no[i], name[i], dob[i], position[i],
          strikeouts[i], era[i], hand[i]);
    }
  }

  public static boolean available() {
    return length < MAX_SIZE;
  }
}
