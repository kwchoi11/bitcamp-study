package pj01;

import java.util.Scanner;

public class App07 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    final int MAX_SIZE = 1;
    int length = 0;

    String[] tableNo = new String[MAX_SIZE];
    String[] personsNo = new String[MAX_SIZE];
    String[] food1 = new String[MAX_SIZE];
    String[] food2 = new String[MAX_SIZE];
    String[] soju = new String[MAX_SIZE];
    String[] beer = new String[MAX_SIZE];

    printTitle();

    for (int i = 0; i < MAX_SIZE; i++) {
      inputMember(scanner, i, tableNo, personsNo, food1, food2, soju, beer);
      length++;
      if (!promptContinue(scanner)) {
        break;
      }
    }

    printMembers(length, tableNo, personsNo, food1, food2, soju, beer);

    scanner.close();

  }
}
