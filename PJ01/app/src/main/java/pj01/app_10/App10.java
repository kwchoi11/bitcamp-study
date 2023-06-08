package pj01.app_10;

import pj01.app_10.handler.OrderHandler;
import pj01.util.Prompt;

public class App10 {

  public static void main(String[] args) {

     printTitle();

     printMenu();

     while (true) {
        String menuNo = Prompt.inputString("메인> ");
        if (menuNo.equals("6")) {
           break;
        } else if (menuNo.equals("menu")) {
           printMenu();
        } else if (menuNo.equals("1")) {
           OrderHandler.inputOrder();
        } else if (menuNo.equals("2")) {
           OrderHandler.printOrders();
        } else if (menuNo.equals("3")) {
           OrderHandler.viewOrder();
        } else if (menuNo.equals("4")) {
           OrderHandler.updateOrder();
        } else if (menuNo.equals("5")) {
           OrderHandler.deleteOrder();
        } else {
           System.out.println(menuNo);
        }
     }

     Prompt.close();
  }

  static void printMenu() {
     System.out.println("1. 주문등록");
     System.out.println("2. 주문목록");
     System.out.println("3. 주문조회");
     System.out.println("4. 주문변경");
     System.out.println("5. 주문삭제");
     System.out.println("6. 종료");
  }

  static void printTitle() {
     System.out.println("테이블별 주문 내역");
     System.out.println("----------------------------------");
  }
}