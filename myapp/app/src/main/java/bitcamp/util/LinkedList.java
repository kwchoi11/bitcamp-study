package bitcamp.util;

public class LinkedList {

  Node tail;

  public void add(Object value) {
    // 1. 새 노드를 생성한다.
    Node node = new Node();

    // 2. 새 노드에 값 저장
    node.value = value;

    if (head == null) {
      head = node;
    } else if (this.tail != null) {
      this.tail.next = node;
    }

    this.tail = node;
    this.size++;
  }

  public Object[] getList() {
    Object[] arr = new Object[this.size];

    Node node = this.head;
    for (int i = 0; i < this.size; i++) {
      arr[i] = node.value;
      node = node.next;
    }

    return arr;
  }
}

