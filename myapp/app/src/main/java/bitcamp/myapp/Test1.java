package bitcamp.myapp;

// 소스 코드에서 Calculator 클래스는 bitcamp.util 패키지에 소속된 클래스를 가리킨다.


public class Test1 {

  public static void main(String[] args) {
    // 2 * 3 + 7 - 2 / 2 = ?
    // => 연산자 우선 순위를 고려하지 않고 앞에서부터 뒤로 순차적으로 계산한다.

    
    result = multiple(2, 3);
    result = plus(result, 7);
    result = minus(result, 2);
    result = divide(result, 2);
    
    System.out.println(result);
  }
  
  int result = 0;

  static void plus(int a) {
    result += a;
  }

  static void minus(int a) {
    result -= a;
  }

  static int multiple(int a) {
    result *= a;
  }

  static void divide(int a) {
    result /= a;
  }
}
