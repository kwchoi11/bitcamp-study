package pj.handler;

import pj.util.List;
import pj.util.Prompt;
import pj.vo.Member;

public class MemberHandler implements Handler {

  private List list;
  private Prompt prompt;
  private String title;

  public MemberHandler(Prompt prompt, String title, List list) {
    this.prompt = prompt;
    this.title = title;
    this.list = list;
  }

  public void execute() {
    printMenu();

    while (true) {
      String menuNo = prompt.inputString("%s> ", this.title);
      if (menuNo.equals("0")) {
        return;
      } else if (menuNo.equals("menu")) {
        printMenu();
      } else if (menuNo.equals("1")) {
        this.inputMember();
      } else if (menuNo.equals("2")) {
        this.printMembers();
      } else if (menuNo.equals("3")) {
        this.viewMember();
      } else if (menuNo.equals("4")) {
        this.updateMember();
      } else if (menuNo.equals("5")) {
        this.deleteMember();
      } else {
        System.out.println("메뉴 번호가 옳지 않습니다!");
      }
    }
  }

  private static void printMenu() {
    System.out.println("1. 등록");
    System.out.println("2. 목록");
    System.out.println("3. 조회");
    System.out.println("4. 변경");
    System.out.println("5. 삭제");
    System.out.println("0. 메인");
  }

  private void inputMember() {
    Member m = new Member();
    m.setName(this.prompt.inputString("이름: "));
    m.setDob(this.prompt.inputString("생년월일: "));
    m.setPosition(inputPosition((char) 0));
    m.setStrikeouts(this.prompt.inputString("탈삼진(투수): "));
    m.setHomerun(this.prompt.inputString("홈런(타자): "));
    m.setHand(inputHand("0"));

    this.list.add(m);
  }

  private void printMembers() {
    System.out.println("-------------------------------------------------------------");
    System.out.println("번호, 이름, 생년월일, 포지션, 탈삼진(투수), 홈런(타자), 투/타");
    System.out.println("-------------------------------------------------------------");

    for (int i = 0; i < this.list.size(); i++) {
      Member m = (Member) this.list.get(i);
      System.out.printf("%d, %s, %s, %s, %s, %s, %s\n",
          m.getNo(), m.getName(), m.getDob(), toPositionString(m.getPosition()),
          m.getStrikeouts(), m.getHomerun(), toHandString(m.getHand()));
    }
  }

  private void viewMember() {
    int memberNo = this.prompt.inputInt("등록 번호를 입력해주세요.");

    Member m = this.findBy(memberNo);
    if (m == null) {
      System.out.println("해당 번호로 등록된 선수가 없습니다.");
      return;
    }

    System.out.printf("이름: %s\n", m.getName());
    System.out.printf("생년월일: %s\n", m.getDob());
    System.out.printf("포지션: %s\n", toPositionString(m.getPosition()));
    System.out.printf("탈삼진(투수): %s\n", m.getStrikeouts());
    System.out.printf("홈런(타자): %s\n", m.getHomerun());
    System.out.printf("투타: %s\n", toHandString(m.getHand()));
  }

  private static String toPositionString(char position) {
    if (position == 'C') {
      return "포수";
    } else if (position == 'P') {
      return "투수";
    } else if (position == 'O') {
      return "외야수";
    } else if (position == 'I') {
      return "내야수";
    }
    throw new IllegalArgumentException("유효하지 않은 포지션입니다.");
  }

  private static String toHandString(String hand) {
    if (hand.equals("RR")) {
      return "우투우타";
    } else if (hand.equals("RL")) {
      return "우투좌타";
    } else if (hand.equals("LL")) {
      return "좌투좌타";
    } else if (hand.equals("LR")) {
      return "좌투우타";
    }
    throw new IllegalArgumentException("다시 선택해주세요.");
  }

  private void updateMember() {
    int memberNo = this.prompt.inputInt("등록 번호를 입력해주세요.");

    Member m = this.findBy(memberNo);
    if (m == null) {
      System.out.println("해당 번호로 등록된 선수가 없습니다.");
      return;
    }

    m.setName(this.prompt.inputString("이름(%s): ", m.getName()));
    m.setDob(this.prompt.inputString("생년월일(%s): ", m.getDob()));
    m.setPosition(inputPosition(m.getPosition()));
    m.setStrikeouts(this.prompt.inputString("탈삼진(투수)(%s): ", m.getStrikeouts()));
    m.setHomerun(this.prompt.inputString("홈런(타자)(%s): ", m.getHomerun()));
    m.setHand(inputHand(m.getHand()));
  }

  private char inputPosition(char position) {
    String label;
    if (position == 0) {
      label = "포지션:\n";
    } else {
      label = String.format("포지션(%s):\n", toPositionString(position));
    }

    while (true) {
      String menuNo = this.prompt.inputString(label +
          "  1. 포수\n" +
          "  2. 투수\n" +
          "  3. 외야수\n" +
          "  4. 내야수\n" +
          "> ");

      switch (menuNo) {
        case "1":
          return Member.CATCHER;
        case "2":
          return Member.PITCHER;
        case "3":
          return Member.OUTFIELDER;
        case "4":
          return Member.INFIELDER;
        default:
          System.out.println("무효한 번호입니다.");
      }
    }
  }

  private String inputHand(String hand) {
    String label;
    if (hand.equals("0")) {
      label = "투타:\n";
    } else {
      label = String.format("투타(%s):\n", toHandString(hand));
    }

    while (true) {
      String menuNo2 = this.prompt.inputString(label +
          "  1. 우투우타\n" +
          "  2. 우투좌타\n" +
          "  3. 좌투좌타\n" +
          "  4. 좌투우타\n" +
          "> ");

      switch (menuNo2) {
        case "1":
          return Member.RR;
        case "2":
          return Member.RL;
        case "3":
          return Member.LL;
        case "4":
          return Member.LR;
        default:
          System.out.println("무효한 번호입니다.");
      }
    }
  }

  private void deleteMember() {
    if (!this.list.remove(new Member(this.prompt.inputInt("등록번호를 입력해주세요.")))) {
      System.out.println("해당 번호로 등록된 선수가 없습니다.");
    }
  }

  private Member findBy(int no) {
    for (int i = 0; i < this.list.size(); i++) {
      Member m = (Member) this.list.get(i);
      if (m.getNo() == no) {
        return m;
      }
    }

    return null;
  }
}
