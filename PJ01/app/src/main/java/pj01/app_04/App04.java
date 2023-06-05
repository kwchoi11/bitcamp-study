package pj01;

import java.util.Scanner;

public class App04 {
  public static void main(String[] args) {
    System.out.println("테이블별 주문 내역");
    System.out.println("------------------------------------");
    
    Scanner scanner = new Scanner(System.in);

    System.out.print("테이블 번호? ");
    int tableNo = scanner.nextInt();

    System.out.print("손님 수? ");
    int personsNo = scanner.nextInt();

    System.out.print("안주 1(오뎅탕(O), 화채(H), 떡볶이(D), 감자튀김(G)? ");
    String str1 = scanner.next();
    char food1 = str1.charAt(0);

    System.out.print("안주 2(오뎅탕(O), 화채(H), 떡볶이(D), 감자튀김(G)? ");
    String str2 = scanner.next();
    char food2 = str2.charAt(0);

    System.out.print("소주(진로(J), 참이슬(C), 처음처럼(F)? ");
    String str3 = scanner.next();
    char soju = str3.charAt(0);

    System.out.print("맥주(카스(CA), 테라(TE))? ");
    String beer = scanner.next();

    System.out.println("------------------------------------");

    System.out.printf("테이블 번호: %d\n", tableNo);
    System.out.printf("손님 수: %d\n", personsNo);
    System.out.printf("안주 1(오뎅탕(O), 화채(H), 떡볶이(D), 감자튀김(G): %c\n", food1);
    System.out.printf("안주 2(오뎅탕(O), 화채(H), 떡볶이(D), 감자튀김(G): %c\n", food2);
    System.out.printf("소주(진로(J), 참이슬(C), 처음처럼(F)): %c\n", soju);
    System.out.printf("맥주(카스(CA), 테라(TE)): %s\n", beer);

    scanner.close();
  }
}
