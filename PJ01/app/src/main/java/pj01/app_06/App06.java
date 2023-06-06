package pj01;

import java.util.Scanner;

public class App06 {
  public static void main(String[] args) {
    System.out.println("테이블별 주문 내역");
    System.out.println("------------------------------------");

    Scanner scanner = new Scanner(System.in);

    final int MAX_SIZE = 3;
    int userId = 1;
    int length = 0;

    int[] tableNo = new int[MAX_SIZE];
    String[] personsNo = new String[MAX_SIZE];
    char[] food1 = new char[MAX_SIZE];
    char[] food2 = new char[MAX_SIZE];
    char[] soju = new char[MAX_SIZE];
    String[] beer = new String[MAX_SIZE];

    for (int i = 0; i < MAX_SIZE; i++) {
      // System.out.print("테이블 번호? ");
      // tableNo[i] = scanner.next();

      System.out.print("손님 수? ");
      personsNo[i] = scanner.next();

      loop1: while (true) {
        System.out.println("안주 1: ");
        System.out.println("  1. 오뎅탕 11.0");
        System.out.println("  2. 화채 8.0");
        System.out.println("  3. 떡볶이 9.0");
        System.out.println("  4. 감자튀김 10.0");
        System.out.println("> ");
        String menuNo = scanner.next();

        switch (menuNo) {
          case "1": 
            food1[i] = 'O';
            break loop1;
          case "2":
            food1[i] = 'H';
            break loop1;
          case "3":
            food1[i] = 'D';
            break loop1;
          case "4":
            food1[i] = 'G';
            break loop1;
          default:
            System.out.println("무효한 번호입니다.");
        }
      }
      
      tableNo[i] = userId++;
      length++;

      System.out.print("계속 하시겠습니까?(Y/n) ");
      scanner.nextLine();
      String response = scanner.nextLine();
      if (!response.equals("") && !response.equalsIgnoreCase("Y")) {
        break;
      }
    }

    System.out.println("------------------------------------");

    System.out.println("테이블 번호, 손님 수, 안주 1, 안주 2, 소주, 맥주");
    System.out.println("------------------------------------");

    for (int i = 0; i < length; i++) {
      System.out.printf("%d, %d, %c, %c, %c, %s\n", tableNo[i], personsNo[i],
        food1[i], food2[i], soju[i], beer[i]);
    }
    scanner.close();
  }
}
