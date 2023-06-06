package pj01;

import pj01.app_09.handler.OrderHandler;
import pj01.app_09.util.Prompt;

public class App09 {
  
  public static void main(String[] args) {

    printTitle();

    while (OrderHandler.available()) {
      OrderHandler.inputMember();
    }

    OrderHandler.printMembers();

    Prompt.close();
  }

  static void printTitles() {
    System.out.println("테이블별 주문 내역");
    System.out.println("----------------------------------");
  }
}
