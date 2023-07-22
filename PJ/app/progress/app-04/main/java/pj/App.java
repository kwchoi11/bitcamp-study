package pj;

// 코드 본문에서 사용할 클래스가 어떤 패키지의 클래스인지 지정한다.
import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    System.out.println("SSG 랜더스 선수 관리 시스템");
    System.out.println("---------------------------");

    // 키보드 스캐너 준비
    Scanner scanner = new Scanner(System.in);

    System.out.print("등번호: ");
    int no = scanner.nextInt();

    System.out.print("이름: ");
    String name = scanner.next();

    System.out.print("생년월일: ");
    String dob = scanner.next();

    System.out.print("포지션: ");
    String position = scanner.next();

    System.out.print("탈삼진: ");
    int strikeouts = scanner.nextInt();

    System.out.print("평균자책점: ");
    float era = scanner.nextFloat();

    System.out.print("투타: ");
    String hand = scanner.next();

    System.out.println("---------------------------------------");

    System.out.printf("번호: %d\n", no);
    System.out.printf("이름: %s\n", name);
    System.out.printf("생년월일: %s\n", dob);
    System.out.printf("포지션: %s\n", position);
    System.out.printf("탈삼진: %d\n", strikeouts);
    System.out.printf("평균자책점: %.3f\n", era);
    System.out.printf("투타: %s\n", hand);

    scanner.close();
  }
}