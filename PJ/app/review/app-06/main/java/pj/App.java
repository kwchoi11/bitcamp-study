package pj;

// 코드 본문에서 사용할 클래스가 어떤 패키지의 클래스인지 지정한다.
import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    System.out.println("SSG 랜더스 선수 관리 시스템");
    System.out.println("---------------------------");

    // 키보드 스캐너 준비
    Scanner scanner = new Scanner(System.in);

    final int MAX_SIZE = 100;
    int userId = 1;
    int length = 0;

    int[] no = new int[MAX_SIZE];
    String[] name = new String[MAX_SIZE];
    String[] dob = new String[MAX_SIZE];
    char[] position = new char[MAX_SIZE];
    int[] strikeouts = new int[MAX_SIZE];
    float[] era = new float[MAX_SIZE];
    String[] hand = new String[MAX_SIZE];

    // 회원정보 등록
    for (int i = 0; i < MAX_SIZE; i++) {

      System.out.print("이름: ");
      name[i] = scanner.next();

      System.out.print("생년월일: ");
      dob[i] = scanner.next();

      loop: while (true) {
        System.out.println("포지션: ");
        System.out.println("  1. 포수");
        System.out.println("  2. 투수");
        System.out.println("  3. 외야수");
        System.out.println("  4. 내야수");
        System.out.println(">  ");
        String menuNo = scanner.next();

        switch (menuNo) {
          case "1":
            position[i] = 'C';
            break loop;
          case "2":
            position[i] = 'P';
            break loop;
          case "3":
            position[i] = 'O';
            break loop;
          case "4":
            position[i] = 'I';
            break loop;
          default:
            System.out.println("무효한 번호입니다.");
        }
      }

      System.out.print("탈삼진: ");
      strikeouts[i] = scanner.nextInt();

      System.out.print("평균자책점: ");
      era[i] = scanner.nextFloat();

      System.out.print("투타: ");
      hand[i] = scanner.next();

      no[i] = userId++;

      length++;

      System.out.print("계속 하시겠습니까?(Y/n) ");
      scanner.nextLine(); // 이전에 next()를 실행한 후 남아 있던 줄바꿈 코드를 제거한다.
      String response = scanner.nextLine();
      if (!response.equals("") && !response.equalsIgnoreCase("Y")) {
        break;
      }
    }

    System.out.println("------------------------------------------------------");
    System.out.println("번호, 이름, 생년월일, 포지션, 탈삼진, 평균자책점, 투타");
    System.out.println("------------------------------------------------------");

    for (int i = 0; i < length; i++) {
      System.out.printf("%d, %s, %s, %c, %d, %f.3, %s\n", no[i], name[i], dob[i], position[i],
          strikeouts[i], era[i], hand[i]);
    }
    scanner.close();
  }
}
