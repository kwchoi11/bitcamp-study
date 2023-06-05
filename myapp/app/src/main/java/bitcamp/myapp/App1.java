package bitcamp.myapp;

import java.util.Scanner;

public class App {
  
  static Scanner scanner = new Scanner(System.in);
  
  public static void main(String[] args) {

    printTitle();

    while (length < MAX_SIZE) {
      MemberHandler.inputMember();
      if (!promptContinue()) {
        break;
      }
    }

    MemberHandler.printMembers();

    scanner.close();
  }

  static void printTitle() {
    System.out.println("나의 목록 관리 시스템");
    System.out.println("----------------------------------");
  }
 
  static boolean promptContinue() {
    String response = prompt("계속 하시겠습니까?(Y/n) ");
    if (!response.equals("") && !response.equalsIgnoreCase("Y")) {
      return false;
    }
    return true;
  }
  
  static String prompt(String title) {
    System.out.print(title);
    return scanner.nextLine();
  }

}
