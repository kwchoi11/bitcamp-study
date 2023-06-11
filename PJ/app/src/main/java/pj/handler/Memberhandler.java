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

  public static void inputMember() {
    if (!available()) {
      System.out.println("더 이상 입력할 수 없습니다.");
      return;
    }

    Member m = new Member();
    m.name = Prompt.inputString("선수 이름을 입력하세요.");
    
    loop:
    while (true) {
      String menuNo = Prompt.inputString("포지션을 선택하세요." +
      " 1. 투수\n" +
      " 2. 타자\n" +
      "> ");

      switch (menuNo) {
        case "1":
          return 
      }
    }
    
    
    
  }

}
