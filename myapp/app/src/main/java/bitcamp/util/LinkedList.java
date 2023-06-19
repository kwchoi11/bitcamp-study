package bitcamp.util;

public class LinkedList {

  Node tail;

  public void add(Object value) {
    // 1. 새 노드를 생성한다.
    Node node = new Node();

    // 2. 새 노드에 값 저장
    node.value = value;

    // 3. 리스트의 마지막 노드에 새 노드를 연결
    if (tail != null) {
      tail.next = node;
    }
    tail = node;
  }
}

