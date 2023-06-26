package bitcamp.util;

public class Test {
  public static void main(String[] args) {
    ArrayList<String> names = new ArrayList<>();
    names.add(new String("홍길동"));
    names.add("임꺽정");
    names.add("안중근");
    names.add("유관순");

    // Object[] arr = names.toArray();
    String[] arr = new String[names.size()];
    names.toArray(arr);

    for (Object item : arr) {
      System.out.println(item); // item의 실제 타입은 String이다.
    }
  }

}
