package pj;

import java.util.Scanner;

public class App {

  static Scanner scanner = new Scanner(System.in);

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

  public static void main(String[] args) {

    printTitle();

    while (length < MAX_SIZE) {
      inputMember();
      if (!promptContinue()) {
        break;
      }
    }

    printMembers();

    scanner.close();
  }

  static void printTitle() {
    System.out.println("SSG 랜더스 선수 관리 시스템");
    System.out.println("---------------------------");
  }

  static void inputMember() {
    name[length] = prompt("이름: ");
    dob[length] = prompt("생년월일: ");

    loop: while (true) {
      String menuNo =
          prompt("포지션:\n" + "  1. 포수\n" + "  2. 투수\n" + "  3. 외야수\n" + "  4. 내야수\n" + "> ");

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

    strikeouts[length] = prompt("탈삼진: ");
    era[length] = prompt("평균자책점: ");
    hand[length] = prompt("투타: ");

    no[length] = userId++;
    length++;
  }

  static boolean promptContinue() {
    String response = prompt("계속 하시겠습니까?(Y/n) ");
    if (!response.equals("") && !response.equalsIgnoreCase("Y")) {
      return false;
    }
    return true;
  }

  static void printMembers() {
    System.out.println("------------------------------------------------------");
    System.out.println("번호, 이름, 생년월일, 포지션, 탈삼진, 평균자책점, 투타");
    System.out.println("------------------------------------------------------");

    for (int i = 0; i < length; i++) {
      System.out.printf("%d, %s, %s, %c, %s, %s, %s\n", no[i], name[i], dob[i], position[i],
          strikeouts[i], era[i], hand[i]);
    }
  }

  static String prompt(String title) {
    System.out.print(title);
    return scanner.nextLine();
  }
}
