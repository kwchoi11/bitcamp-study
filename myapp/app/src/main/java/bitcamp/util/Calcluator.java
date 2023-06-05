package bitcamp.util;

public class Calcluator {
  static int result; // 스테틱 변수는 기본 값 0으로 초기화된다.

  static void init(int a) {
    result = a;
  }

  static void plus(int a) {
    result += a;
  }

  static void minus(int a) {
    result -= a;
  }

  static void multiple(int a) {
    result *= a;
  }

  static void divide(int a) {
    result /= a;
  }
}
