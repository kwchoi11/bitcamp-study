package bitcamp.test;

class A {
  static int v1;

  static void m1() {}

  static {
    System.out.println("A 클래스의 스태틱 블록 실행!1");
  }
  static {
    System.out.println("A 클래스의 스태틱 블록 실행!2");
  }
  static {
    System.out.println("A 클래스의 스태틱 블록 실행!3");
  }
}


public class Exam01 {

  public static void main(String[] args) {
    A obj;

    // A.v1 = 100;
    // A.m1();
    // obj = new A();
    // 클래스는 스태틱 필드를 쓰려는 시점, 메서드를 호출하는 시점, new 명령어로 인스턴스를 만드는 시점에 로딩된다.
    // 그리고 한 번 로딩되면 다시 로딩되지 않는다.


    // 클래스 강제 로딩
    try {
      Class.forName("bitcamp.test.A"); // fully-qualified class name (FQName) 패키지 이름을 포함한 클래스의
                                       // 전체 이름을 입력해야 한다.
    } catch (ClassNotFoundException e) {
      System.out.println("클래스 못 찾네!");
    }



  }

}
