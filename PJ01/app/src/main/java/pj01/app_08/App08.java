package pj01;

import java.util.Scanner;

public class App08 {
  
  static Scanner scanner = new Scanner(System.in);

  static final int MAX_SIZE = 1;
  int length = 0;

  String[] tableNo = new String[MAX_SIZE];
  String[] personsNo = new String[MAX_SIZE];
  String[] food1 = new String[MAX_SIZE];
  String[] food2 = new String[MAX_SIZE];
  String[] soju = new String[MAX_SIZE];
  String[] beer = new String[MAX_SIZE];

  public static void main(String[] args) {

    printTitle();

    while (length < MAX_SIZE) {
      inputMember();
    }

    printMembers();

    scanner.close();
  }

  

}
