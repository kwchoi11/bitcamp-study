package bitcamp.test;

public class Test {
  public static void main(String[] args) {
    Calculator c = new Calculator2();

    Calculator2 c2 = (Calculator2) c;

    System.out.println(c2.minus(100, 200));
    System.out.println(c.plus(100, 200));

  }

}
