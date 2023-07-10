package pj;

public class App {
  public static void main(String[] args) {
    System.out.println("SSG 랜더스 선수 관리 시스템");
    System.out.println("---------------------");

    int no = 29;
    String name = "김광현";
    int age = 34;
    String position = "투수";
    int strikeouts = 58;
    float ERA = 4.005f;
    String hand = "좌투좌타";


    System.out.printf("등번호: %d\n", no);
    System.out.printf("이름: %s\n", name);
    System.out.printf("나이: %d\n", age);
    System.out.printf("포지션: %s\n", position);
    System.out.printf("탈삼진: %d\n", strikeouts);
    System.out.printf("평균자책점: %f\n", ERA);
    System.out.printf("투타: %s\n", hand);
  }
}


