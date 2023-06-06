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

    String[] tableNo = new String[MAX_SIZE];
    String[] personsNo = new String[MAX_SIZE];
    String[] food1 = new String[MAX_SIZE];
    String[] food2 = new String[MAX_SIZE];
    String[] soju = new String[MAX_SIZE];
    String[] beer = new String[MAX_SIZE];

    for (int i = 0; i < MAX_SIZE; i++) {
      
      loop: while (true) {
        System.out.println("테이블 번호를 선택해주세요. ");
        System.out.println(" 1. 1번");
        System.out.println(" 2. 2번");
        System.out.println(" 3. 3번");
        System.out.println(" 4. 4번");
        System.out.println(" 5. 5번");
        System.out.println(" 6. 6번");
        System.out.println(" 7. 7번");
        System.out.println(" 8. 8번");
        System.out.println(" 9. 9번");
        System.out.println(" 10. 10번");
        System.out.println("> ");
        String noTable = scanner.next();

        switch (noTable) {
          case "1":
            tableNo[i] = "1번 테이블";
            break loop;
          case "2":
            tableNo[i] = "2번 테이블";
            break loop;
          case "3":
            tableNo[i] = "3번 테이블";
            break loop;
          case "4":
            tableNo[i] = "4번 테이블";
            break loop;
          case "5":
            tableNo[i] = "5번 테이블";
            break loop;
          case "6":
            tableNo[i] = "6번 테이블";
            break loop;
          case "7":
            tableNo[i] = "7번 테이블";
            break loop;
          case "8":
            tableNo[i] = "8번 테이블";
            break loop;
          case "9":
            tableNo[i] = "9번 테이블";
            break loop;
          case "10":
            tableNo[i] = "10번 테이블";
            break loop;
          default:
            System.out.println("무효한 번호입니다. 다시 선택해 주세요.");
        }
      }

      System.out.print("몇 분이세요? ");
      personsNo[i] = scanner.next();

      loop1: while (true) {
        System.out.println("안주를 선택해주세요.: ");
        System.out.println("  1. 오뎅탕 11.0");
        System.out.println("  2. 화채 8.0");
        System.out.println("  3. 떡볶이 9.0");
        System.out.println("  4. 감자튀김 10.0");
        System.out.println("> ");
        String menuNo = scanner.next();

        switch (menuNo) {
          case "1": 
            food1[i] = "오뎅탕";
            break loop1;
          case "2":
            food1[i] = "화채";
            break loop1;
          case "3":
            food1[i] = "떡볶이";
            break loop1;
          case "4":
            food1[i] = "감자튀김";
            break loop1;
          default:
            System.out.println("무효한 번호입니다. 다시 선택해 주세요.");
        }
      }
      


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
      System.out.printf("%s, %s, %s, %s, %s, %s\n", tableNo[i], personsNo[i],
        food1[i], food2[i], soju[i], beer[i]);
    }
    scanner.close();
  }
}
