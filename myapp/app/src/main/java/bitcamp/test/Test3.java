package bitcamp.test;

import bitcamp.test.p1.A;

public class Test3 {
  public static void main(String[] args) {
    A obj = new A();

//    obj.v1 = 100;  // 접근 불가 !
//    obj.v2 = 200;  // 접근 불가 !
//    obj.v3 = 300;  // 접근 불가 ! <== 상속받은 멤버가 아니다.
    obj.v4 = 400;
}
