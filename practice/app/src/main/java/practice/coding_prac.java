// 프로그래머스 Java 코테연습 - 문자열 돌리기.
// Hello 를
// H
// E
// L
// L
// O 와 같이 출력하기. 

package practice;

public class coding_prac {
  public static void main(String[] args) {
    String a = "Hello";

    for(int i = 0; i < a.length(); i++) {
      System.out.println(a.substring(i, i+1));
    }
  }
}
