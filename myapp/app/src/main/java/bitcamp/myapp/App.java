package bitcamp.myapp;

public class App {

  public static void main(String[] args) {
    System.out.println("나의 목록 관리 시스템");
    System.out.println("-------------------------------------");

    int no = 100;
    String name = "홍길동";
    int age = 20;
    boolean working = true;
    char gender = 'M';
    float leftEye = 1.5f;
    float rightEye = 1.0f;

    System.out.printf("번호: %d\n", no);
    System.out.printf("이름: %s\n", name);
    System.out.printf("나이: %d\n", age);
    System.out.printf("재직자: %b\n", working);
    System.out.printf("성별(남자(M), 여자(W)): %c\n", gender);
    System.out.printf("좌우시력: %.1f,%.1f\n", leftEye, rightEye);

    // System.out.print("번호: ");
    // System.out.println(100);

    // System.out.print("번호: ");
    // System.out.println(100);
    
    // System.out.printf("이름: %s", "홍길동"); //java에서 print, println, printf 차이점 찾아보기.
    // System.out.println();

    // System.out.println("나이: " + 20);
    
    // System.out.printf("재직자: %b\n", true); //'\n' 과 같은 문자를 escape character라고 부른다.

    // System.out.printf("성별(남자(M), 여자(W)): %c\n", 'M'); //"M"과 같이 문자열 처리""를 하면 오류 발생. 

    // System.out.printf("좌우시력: %.1f,%.1f\n", 1.5f, 1.0f);
  }
}
//System  .  out  .  println            ("홍길동");
//상자       도구       기능(function)   기능 수행에 필요한 값
//클래스     객체      메소드(method)     argument, parameter
//class    object
//         instance