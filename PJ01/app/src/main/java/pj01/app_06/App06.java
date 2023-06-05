package pj01;

import java.util.Scanner;

public class App06 {
  public static void main(String[] args) {
    System.out.println("테이블별 주문 내역");
    System.out.println("------------------------------------");

    Scanner scanner = new Scanner(System.in);

    final int MAX_SIZE = 3;
    int tableNo = 1;
    int length = 0;

    int[] tableNo = new int[MAX_SIZE];
    int[] personsNo = new int[MAX_SIZE];
    char[] food1 = new char[MAX_SIZE];
    char[] food2 = new char[MAX_SIZE];
    char[] soju = new char[MAX_SIZE];
    String[] beer = new String[MAX_SIZE];

    for (int i = 0; i < MAX_SIZE; i++) {
      System.out.print("테이블 번호? ");
      tableNo[i] = scanner.next();

      System.out.print("손님 수? ");
      personsNo[i] = scanner.next();

      loop1: while (true) {
        System.out.println("안주 1: ");
        System.out.println("  1. 오뎅탕 11.0(O), 화채 8.0(H), 떡볶이 9.0(D), 감자튀김 10.0(G)")
      }
    }
  }
}
