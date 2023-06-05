package pj01;

import java.util.Scanner;

public class App05 {
  public static void main(String[] args) {
    System.out.println("테이블별 주문 내역");
    System.out.println("------------------------------------");

    Scanner scanner = new Scanner(System.in);

    final int SIZE = 3;

    int[] tableNo = new int[SIZE];
    int[] personsNo = new int[SIZE];
    char[] food1 = new char[SIZE];
    char[] food2 = new char[SIZE];
    char[] soju = new char[SIZE];
    String[] beer = new String[SIZE];

    for (int i = 0; i < SIZE; i++) {
      System.out.print("테이블 번호? ");
      tableNo[i] = scanner.nextInt();

      System.out.print("손님 수? ");
      personsNo[i] = scanner.nextInt();

      System.out.print("안주 1(오뎅탕(O), 화채(H), 떡볶이(D), 감자튀김(G)? ");
      String str1 = scanner.next();
      food1[i] = str1.charAt(0);

      System.out.print("안주 2(오뎅탕(O), 화채(H), 떡볶이(D), 감자튀김(G)? ");
      String str2 = scanner.next();
      food2[i] = str2.charAt(0);

      System.out.print("소주(진로(J), 참이슬(C), 처음처럼(F)? ");
      String str3 = scanner.next();
      soju[i] = str3.charAt(0);

      System.out.print("맥주(카스(CA), 테라(TE))? ");
      beer[i] = scanner.next();
    }

    System.out.println("------------------------------------");

    for (int i = 0; i < SIZE; i++) {
      System.out.printf("테이블 번호: %d\n", tableNo[i]);
      System.out.printf("손님 수: %d\n", personsNo[i]);
      System.out.printf("안주 1(오뎅탕(O), 화채(H), 떡볶이(D), 감자튀김(G): %c\n", food1[i]);
      System.out.printf("안주 2(오뎅탕(O), 화채(H), 떡볶이(D), 감자튀김(G): %c\n", food2[i]);
      System.out.printf("소주(진로(J), 참이슬(C), 처음처럼(F)): %c\n", soju[i]);
      System.out.printf("맥주(카스(CA), 테라(TE)): %s\n", beer[i]);
    }
    scanner.close();
  }
}
