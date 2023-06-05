package pj01;

public class App03 {
  public static void main(String[] args) {
    System.out.println("테이블별 주문 내역");
    System.out.println("------------------------------------");

    int tableNo = 8;
    int personsNo = 4;
    char food1 = 'O';
    char food2 = 'D';
    char soju = 'J';
    String beer = "CA";

    System.out.printf("테이블 번호: %d\n", tableNo);
    System.out.printf("손님 수: %d\n", personsNo);
    System.out.printf("안주 1(오뎅탕(O), 화채(H), 떡볶이(D), 감자튀김(G): %c\n", food1);
    System.out.printf("안주 2(오뎅탕(O), 화채(H), 떡볶이(D), 감자튀김(G): %c\n", food2);
    System.out.printf("소주(진로(J), 참이슬(C), 처음처럼(F)): %c\n", soju);
    System.out.printf("맥주(카스(CA), 테라(TE)): %s\n", beer);
  }
}
