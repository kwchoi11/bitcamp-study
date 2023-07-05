package bitcamp.test;

// 예제 oop/ex03/210~
class B {
  int v1;
  int v2;
  // {
  // System.out.println("111");
  // }
  // {
  // System.out.println("222");
  // }
  // {
  // System.out.println("333");
  // }
  // 위와 같이 전부 쪼개면 좋지 않다.
  // 인스턴스 블록도 스태틱 블록과 마찬가지로 하나로 합칠 수 있다.

  // {
  // System.out.println("111");
  // System.out.println("222");
  // System.out.println("333");
  // } // 이렇게 합치는 게 좋다.
  // 얘네가 인스턴스 블록.

  //
  // public B() {
  // System.out.println("444");
  // }
  //
  // public B(int b) {
  // System.out.println("555");
  // }
  //
  // public B(int a, int b) {
  // System.out.println("666");
  // } // 얘네는 생성자 블록.

  // 인스턴스 블록은 무조건 생성자 앞에 순서대로 붙는다.
  // 컴파일하면 인스턴스 블록 안의 코드들이 생성자로 옮겨지는데, 맨 위로 들어가서 먼저 실행된다.
  // 즉, 인스턴스 블록 안의 코드가 먼저 실행되고 생성자 안의 코드가 실행된다.

  public B() {
    System.out.println("111");
    System.out.println("222");
    System.out.println("333");
    System.out.println("444");
  }

  public B(int b) {
    System.out.println("111");
    System.out.println("222");
    System.out.println("333");
    System.out.println("555");
  }

  public B(int a, int b) {
    System.out.println("111");
    System.out.println("222");
    System.out.println("333");
    System.out.println("666");
  }
  // 컴파일하면 요렇게 바뀐다.
}



public class Exam02 {

  public static void main(String[] args) {
    new B();
    new B();
    new B();
    new B();

  }

}
