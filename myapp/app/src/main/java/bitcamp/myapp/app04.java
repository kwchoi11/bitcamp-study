package bitcamp.myapp;

// 코드 본문에서 사용할 클래스가 어떤 패키지의 클래스인지 지정한다.
import java.util.Scanner;

public class app04 {
  public static void main(String[] args) {
    System.out.println("나의 목록 관리 시스템");
    System.out.println("-------------------------------");

    // 키보드 스캐너 준비
    Scanner scanner = new Scanner(System.in);
    
    System.out.print("번호? ");
    int no = scanner.nextInt();

    System.out.print("이름? ");
    String name = scanner.next();

    

  }
}
