package bitcamp.util;

public interface List<E> {
  boolean add(E value);

  E get(int index);

  E[] toArray();

  boolean remove(E value);

  E remove(int index);

  int size();
}
