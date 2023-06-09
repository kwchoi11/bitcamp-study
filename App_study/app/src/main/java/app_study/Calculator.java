package app_study.util;

public class Calculator {
  private static int result = 0;

  public static int getResult() {
    return result;
  }

  public static void init(int a) {
    result = a;
  }

  public static void plus(int a) {
    result += a;
  }

  public static void minus(int a) {
    result -= a;
  }

  public static void multiple(int a) {
    result *= a;
  }

  public static void divide(int a) {
    result /= a;
  }
}
