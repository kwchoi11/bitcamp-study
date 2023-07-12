package bitcamp.test;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Stateful 방식으로 통신하기
public class CalcClient1 {
  static Pattern pattern = Pattern.compile("[0-9]+|\\p{Punct}");

  public static void main(String[] args) throws Exception {
    try (Socket socket = new Socket("localhost", 8888);
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        DataInputStream in = new DataInputStream(socket.getInputStream());
        Scanner keyScan = new Scanner(System.in);) {

      while (true) {
        System.out.print("계산식(예: + 3)> ");
        String input = keyScan.nextLine();

        if (input.equals("quit")) {
          out.writeUTF("quit");
          break;
        }

        try {
          Expression expr = parseExpression(input);

          out.writeUTF(expr.op);
          out.writeInt(expr.value);

          String result = in.readUTF();
          System.out.printf("결과: %s\n", result);

        } catch (Exception e) {
          System.out.println("계산식이 옳지 않습니다!");
        }
      }
    }
  }

  public static Expression parseExpression(String expr) throws Exception {
    Matcher matcher = pattern.matcher(expr);

    ArrayList<String> values = new ArrayList<>();
    while (matcher.find()) {
      values.add(matcher.group());
    }

    if (values.size() != 2) {
      throw new Exception("계산식이 옳지 않습니다!");
    }

    Expression obj = new Expression();
    obj.op = values.get(0);
    obj.value = Integer.parseInt(values.get(1));

    return obj;
  }

  static class Expression {
    String op;
    int value;
  }
}
