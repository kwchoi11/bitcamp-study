package bitcamp.myapp;

class Calculator {
  static int result; //스태틱 변수는 기본 값 0으로 초기화된다.
}

public class Test1 {

  public static void main(String[] args) {
    // 2 * 3 + 7 - 2 / 2 = ?
    // => 연산자 우선 순위를 고려하지 않고 앞에서부터 뒤로 순차적으로 계산한다.

    bitcamp.util.Calculator.init(2);
    Calculator.multiple(3);
    Calulator.plus(7);
    Calculaor.minus(2);
    Calculator.divide(2);
    System.out.println(Calculator.result);
  }
}
