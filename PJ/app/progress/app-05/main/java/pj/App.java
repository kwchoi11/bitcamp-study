package pj;

// 코드 본문에서 사용할 클래스가 어떤 패키지의 클래스인지 지정한다.
import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    System.out.println("SSG 랜더스 선수 관리 시스템");
    System.out.println("---------------------------");

    // 키보드 스캐너 준비
    Scanner scanner = new Scanner(System.in);

    final int SIZE = 100;

    int[] no = new int[SIZE];
    String[] name = new String[SIZE];
    String[] dob = new String[SIZE];
    String[] position = new String[SIZE];
    int[] strikeouts = new int[SIZE];
    float[] era = new float[SIZE];
    String[] hand = new String[SIZE];

    for (int i = 0; i < SIZE; i++) {
      System.out.print("번호: ");
      no[i] = scanner.nextInt();

      System.out.print("이름: ");
      name[i] = scanner.next();

      System.out.print("생년월일: ");
      dob[i] = scanner.next();

      System.out.print("포지션: ");
      position[i] = scanner.next();

      System.out.print("탈삼진: ");
      strikeouts[i] = scanner.nextInt();

      System.out.print("평균자책점: ");
      era[i] = scanner.nextFloat();

      System.out.print("투타: ");
      hand[i] = scanner.next();
    }

    System.out.println("--------------------------------------");

    for (int i = 0; i < SIZE; i++) {
      System.out.printf("번호: %d\n", no[i]);
      System.out.printf("이름: %s\n", name[i]);
      System.out.printf("생년월일: %s\n", dob[i]);
      System.out.printf("포지션: %s\n", position[i]);
      System.out.printf("탈삼진: %d\n", strikeouts[i]);
      System.out.printf("평균자책점: %.3f\n", era[i]);
      System.out.printf("투타: %s\n", hand[i]);
    }
    scanner.close();
  }
}


