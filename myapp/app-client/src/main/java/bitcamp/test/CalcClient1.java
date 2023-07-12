package bitcamp.test;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalcClient1 {
  public static void main(String[] args) throws Exception {
    try (
        // Socket socket = new Socket("localhost", 8888);
        // DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        // DataInputStream in = new DataInputStream(socket.getInputStream());
        Scanner keyscan = new Scanner(System.in);) {

      System.out.print("계산식> ");
      String expr = keyscan.nextLine();



    }
  }

  public String[] parsExpression(String expr) {
    Pattern pattern = Pattern.compile("[0-9]+|\\p{Punct}");
    Matcher matcher = pattern.matcher(expr);

    ArrayList<String> values = new ArrayList<>();
    while (matcher.find()) {
      values.add(matcher.group());
    }
    return values.toArray(new String[] {});
  }
}


