package bitcamp.myapp;

// 코드 본문에서 사용할 클래스가 어떤 패키지의 클래스인지 지정한다. 
import java.io.InputStream;
import java.util.Scanner;

public class App {

  public static void main(String[] args) {
    System.out.println("나의 목록 관리 시스템");
    System.out.println("-------------------------------------");

    // 키보드 스캐너 준비
    Scanner scanner = new java.util.Scanner(System.in);

    // int count = 0;

    int[] no = new int[3];
    String[] name = new String[3];
    int[] age = new int[3];
    boolean[] working = new boolean[3];
    char[] gender = new char[3];
    float[] leftEye = new float[3];
    float[] rightEye = new float[3];

    for (int count = 0; count < 3; count++) {
      // while (count < 3) {
      // count = count + 1;
      // count += 1;
      // count++;

      System.out.print("번호? ");
      no[count] = scanner.nextInt();

      System.out.print("이름? ");
      name[count] = scanner.next();

      System.out.print("나이? ");
      age[count] = scanner.nextInt();

      System.out.print("재직중? ");
      working[count] = scanner.nextBoolean();

      System.out.print("성별(남자:M, 여자: W)? ");
      String str = scanner.next();
      gender[count] = str.charAt(0);

      System.out.print("시력(왼쪽, 오른쪽)? ");
      leftEye[count] = scanner.nextFloat();
      rightEye[count] = scanner.nextFloat();

      // count++;
    }

    System.out.println("----------------------------------------");

    // int no = 100;
    // String name = "홍길동";
    // int age = 20;
    // boolean working = true;
    // char gender = 'M';
    // float leftEye = 1.5f;
    // float rightEye = 1.0f;

    for (int count = 0; count < 3; count++) {
      System.out.printf("번호: %d\n", no[count]);
      System.out.printf("이름: %s\n", name[count]);
      System.out.printf("나이: %d\n", age[count]);
      System.out.printf("재직자: %b\n", working[count]);
      System.out.printf("성별(남자(M), 여자(W)): %c\n", gender[count]);
      System.out.printf("좌우시력: %.1f,%.1f\n", leftEye[count], rightEye[count]);
    }
    scanner.close();
    // System.out.print("번호: ");
    // System.out.println(100);

    // System.out.print("번호: ");
    // System.out.println(100);

    // System.out.printf("이름: %s", "홍길동"); //java에서 print, println, printf 차이점 찾아보기.
    // System.out.println();

    // System.out.println("나이: " + 20);

    // System.out.printf("재직자: %b\n", true); //'\n' 과 같은 문자를 escape character라고 부른다.

    // System.out.printf("성별(남자(M), 여자(W)): %c\n", 'M'); //"M"과 같이 문자열 처리""를 하면 오류
    // 발생.

    // System.out.printf("좌우시력: %.1f,%.1f\n", 1.5f, 1.0f);
  }
}
// System . out . println ("홍길동");
// 상자 도구 기능(function) 기능 수행에 필요한 값
// 클래스 객체 메소드(method) argument, parameter
// class object
// instance