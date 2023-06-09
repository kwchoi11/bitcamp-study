package app_study.util;

public class Calculator {
  private int result = 0;

  // non-tatic 필드는 new 명령을 실행해야만 heap 영역에 생성된다. 
  public static int getResult(Calculator c) {
    return c.result;
  }

  public static void init(Calculator c, int a) {
    c.result = a;
  }

  public static void plus(Calculator c, int a) {
    c.result += a;
  }

  public static void minus(Calculator c, int a) {
    c.result -= a;
  }

  public static void multiple(Calculator c, int a) {
    c.result *= a;
  }

  public static void divide(Calculator c, int a) {
    c.result /= a;
  }
}
