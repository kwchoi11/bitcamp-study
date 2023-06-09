package app_study;

// 소스 코드에서 Calculator 클래스는 bitcamp.util 패키지에 소속된 클래스를 가리킨다.

import app_study.util.Calculator;

public class Test1 {

  public static void main(String[] args) {
    // 2 * 3 + 7 - 2 / 2 = ?
    // 3 - 1 * 7 + 15 / 3 = ?
    // => 연산자 우선 순위를 고려하지 않고 앞에서부터 뒤로 순차적으로 계산한다.
    // => 위의 계산을 동시에 수행하기.

    // 두 개의 계산 결과를 저장할 수 있는 result 변수를 준비한다. 
    Calculator c1 = new Calculator();
    Calculator c2 = new Calculator();

    Calculator.divide(c2, 3);
    Calculator.init(c1, 2);
    Calculator.multiple(c2, 7);
    Calculator.multiple(c1, 3);
    Calculator.plus(c2, 15);
    Calculator.plus(c1, 7);
    Calculator.minus(c1, 2);
    Calculator.init(c2, 3);
    Calculator.divide(c1, 2);
    Calculator.minus(c2, 1);
    
    System.out.println(Calculator.getResult(c1));
    System.out.println(Calculator.getResult(c2));

  }
  
  
  
}
