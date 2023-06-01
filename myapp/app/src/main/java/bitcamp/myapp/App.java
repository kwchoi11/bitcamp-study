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

    final int MAX_SIZE = 100;
    int userId = 1;
    int length = 0;

    // int i = 0;

    int[] no = new int[MAX_SIZE];
    String[] name = new String[MAX_SIZE];
    String[] email = new String[MAX_SIZE];
    String[] password = new String[MAX_SIZE];
    char[] gender = new char[MAX_SIZE];

    // 회원정보 등록
    for (int i = 0; i < MAX_SIZE; i++) {
      // while (i < 3) {
      // i = i + 1;
      // i += 1;
      // i++;

      System.out.print("이름? ");
      name[i] = scanner.next();

      System.out.print("이메일? ");
      email[i] = scanner.next();

      System.out.print("암호? ");
      password[i] = scanner.next();

      loop: while (true) {
        System.out.println("성별: ");
        System.out.println(" 1. 남자");
        System.out.println(" 2. 여자");
        System.out.print("> ");
        String menuNo = scanner.next();

        // if문 사용
        // if (menuNo.equals("1")) {
        //   gender[i] = 'M';
        //   break;
        // } else if (menuNo.equals("2")) {
        //   gender[i] = 'W';
        //   break;
        // } else { 
        //   System.out.println("무효한 번호입니다.");
        // }

        // switch문 사용
        switch (menuNo) {
          case "1": 
            gender[i] = 'M';
            break loop;
          case "2":
            gender[i] = 'W';
            break loop;
          default:
            System.out.println("무효한 번호입니다.");
        }
      }

      // gender[i] = scanner.next().charAt(0);

      no[i] = userId++;

      length++;

      System.out.print("계속 하시겠습니까?(Y/n)");
      scanner.nextLine(); // 이전 next()를 실행한 후 남아있는 줄바꿈 코드를 제거하기 위함.
      String response = scanner.nextLine();
      if (!response.equals("") && !response.equalsIgnoreCase("Y")) {
        break;
      }
    }

    System.out.println("----------------------------------------");

    // int no = MAX_SIZE;
    // String name = "홍길동";
    // int age = 20;
    // boolean working = true;
    // char gender = 'M';
    // float leftEye = 1.5f;
    // float rightEye = 1.0f;
    
    System.out.println("번호, 이름, 이메일, 성별\n");
    System.out.println("----------------------------------------");

    for (int i = 0; i < length; i++) {
      System.out.printf("%d, %s, %s, %c\n", no[i], name[i], email[i], gender[i]);
    }
    scanner.close();
    // System.out.print("번호: ");
    // System.out.println(MAX_SIZE);

    // System.out.print("번호: ");
    // System.out.println(MAX_SIZE);

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