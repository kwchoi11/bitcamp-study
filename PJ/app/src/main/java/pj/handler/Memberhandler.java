package pj.handler;

import pj.util.Prompt;
import pj.vo.Member;

public class Memberhandler {
  
  static final int MAX_SIZE = 100;
  static Member[] members = new Member[MAX_SIZE];
  static int userId = 1;
  static int length = 0;

  static final char LEFT = 'L';
  static final char RIGHT = 'W';
  static final char PITCHER = 'P';
  static final char BATTER = 'B';

  public static void inputMember() {
    if (!available()) {
      System.out.println("더 이상 입력할 수 없습니다.");
      return;
    }

    Member m = new Member();
    m.name = Prompt.inputString("선수 이름을 입력하세요.");
    m.pos = inputPosition((char)0);
    m.era = Prompt.inputString("선수의 평균자책점을 입력하세요. (투수)");
    m.sk = Prompt.inputString("선수의 탈삼진을 입력하세요. (투수)");
    m.ba = Prompt.inputString("선수의 타율을 입력하세요. (타자)");
    m.hr = Prompot.inputString("선수의 홈런 수를 입력하세요. (타자)");
    m.hand = inputHand((char)0);
    m.no = userId++;

    members[length++] = m;
  }


  

  private static char inputPosition(char position) {
    String label;
    if (position == 0) {
      label = "포지션을 입력하세요\n";
    } else {
      label = String.format("포지션을 입력하세요(%s).\n", toPositionString(position));
    }
    loop: while (true) {
      String menuNo = Prompt.inputString(label +
      " 1. 투수\n" +
      " 2. 타자\n" +
      "> ");

      switch (menuNo) {
        case "1":
          return PITCHER;
        case "2":
          return BATTER;
        default:
          System.out.println("무효한 번호입니다.");
      }
    }
  }


  private static char inputHand(char hand) {
    String label;
    if (hand == 0) {
      label = "좌완(타)/우완(타)";
    } else {
      label = String.format("좌완(타)/우완(타)(%s)\n", toHandString(hand));
    }
    loop: while (true) {
      String menuNo = Prompt.inputString(lebel +
      " 1. 좌완(타)\n" +
      " 2. 우완(타)\n" +
      "> ");

      switch (menuNo) {
        case "1":
          return LEFT;
        case "2":
          return RIGHT;
        default:
          System.out.println("무효한 번호입니다.");
      }
    }
  }



}
