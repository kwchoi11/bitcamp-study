package bitcamp.util;

import java.util.ArrayList;

public class ThreadPool implements ResourcePool<ManagedThread> {

  ArrayList<ManagedThread> list = new ArrayList<>();

  @Override
  public ManagedThread getResource() {
    if (list.size() == 0) {
      ManagedThread t = new ManagedThread(this);
      System.out.println("새 스레드 생성!");

      t.start();
      System.out.println("새 스레드 시작!");

      System.out.println("새 스레드 리턴!");
      System.out.println("================> " + list.size());
      return t;
    }

    System.out.println("==================> " + list.size());
    System.out.println("기존 스레드 리턴");
    return list.remove(0);
  }

  @Override
  public void returnResource(ManagedThread resource) {
    list.add(resource);
    System.out.println("=================>" + list.size());
  }
}
