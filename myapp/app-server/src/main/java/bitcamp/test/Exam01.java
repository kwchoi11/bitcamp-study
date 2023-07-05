package bitcamp.test;

class A {
  static int v1 = 111;
  // 컴파일 했을 때, v1의 값은 최종적으로 300이 된다.
  // 필드에서 선언된 값이 스태틱 블록 안으로 들어간다.
  // 위에서 선언된 111은 스태틱 블록의 맨 위로 들어간다.
  static {
    v1 = 100;
    System.out.println("A 클래스의 스태틱 블록 실행!1");
    v1 = 200;
    System.out.println("A 클래스의 스태틱 블록 실행!2");
    v1 = 300;
    System.out.println("A 클래스의 스태틱 블록 실행!3");
    v2 = 333;
  }
  static int v2 = 222;
  // 컴파일했을 때, v2의 값은 최종적으로 222가 된다.
  // 필드에서 선언된 값이 스태틱 블록 안으로 들어간다.
  // 위에서 선언된 222는 스태틱 블록의 맨 아래로 들어간다.
  // 마지막에 선언된 값이 최종 값이 된다.

  static void m1() {}



  // static {
  // System.out.println("A 클래스의 스태틱 블록 실행!1");
  // }
  // static {
  // System.out.println("A 클래스의 스태틱 블록 실행!2");
  // }
  // static {
  // System.out.println("A 클래스의 스태틱 블록 실행!3");
  // }

  // 한 블록 안에 여러 개의 스태틱을 만드는 것은 의미없는 행동이다.
  // 컴파일하면 어차피 하나로 합쳐지기 때문 !

  // static {
  // System.out.println("A 클래스의 스태틱 블록 실행!3");
  // System.out.println("A 클래스의 스태틱 블록 실행!3");
  // System.out.println("A 클래스의 스태틱 블록 실행!3");
  // }
  // 요렇게 스태틱 블록 하나로 묶어서 작성해주는 게 좋다.
}


public class Exam01 {

  public static void main(String[] args) {
    // A obj; // 클래스 로딩 안 됨.

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
