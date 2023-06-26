package bitcamp.util;

public interface List<T> {
  boolean add(T value);

  T get(int index);

  T[] toArray();

  boolean remove(T value);

  T remove(int index);

  int size();
}
