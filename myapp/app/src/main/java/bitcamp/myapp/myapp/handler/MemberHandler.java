package bitcamp.myapp.myapp.handler;

import bitcamp.util.Prompt;

public class MemberHandler {

  static final int MAX_SIZE = 100;
  static int[] no = new int[MAX_SIZE];
  static String[] name = new String[MAX_SIZE];
  static String[] email = new String[MAX_SIZE];
  static String[] password = new String[MAX_SIZE];
  static char[] gender = new char[MAX_SIZE];
  static int userId = 1;
  static int length = 0;

  static final char MALE = 'M';
  static final char FEMALE = 'W';

  public static void inputMember() {
    if (!available()) {
      System.out.println("더이상 입력할 수 없습니다!");
      return;
    }

    name[length] = Prompt.inputString("이름? ");
    email[length] = Prompt.inputString("이메일? ");
    password[length] = Prompt.inputString("암호? ");
    gender[length] = inputGender((char)0);
    

    no[length] = userId++;
    length++;
  }

  public static void printMembers() {
    System.out.println("---------------------------------------");
    System.out.println("번호, 이름, 이메일, 성별");
    System.out.println("---------------------------------------");

    for (int i = 0; i < length; i++) {
      System.out.printf("%d, %s, %s, %s\n", 
        no[i], name[i], email[i], 
        toGenderString(gender[i]));
    }
  }

  public static void viewMember() {
    String memberNo = Prompt.inputString("번호? ");
    for (int i = 0; i < length; i++) {
      if (no[i] == Integer.parseInt(memberNo)) {
        System.out.printf("이름: %s\n", name[i]);
        System.out.printf("이메일: %s\n", email[i]);
        System.out.printf("성별: %s\n", toGenderString(gender[i]));
        return;
      }
    }
    System.out.println("해당 번호의 회원이 없습니다!");
  }

  public static String toGenderString(char gender) {
    return gender == 'M' ? "남성" : "여성";
  }

  public static void updateMember() {
    String memberNo = Prompt.inputString("번호? ");
    for (int i = 0; i < length; i++) {
      if (no[i] == Integer.parseInt(memberNo)) {
        System.out.printf("이름(%s)? ", name[i]);
        name[i] = Prompt.inputString("");
        System.out.printf("이메일(%s)? ", email[i]);
        name[i] = Prompt.inputString("");
        System.out.printf("새암호? ");
        password[i] = Prompt.inputString("");
        gender[i] = inputGender(gender[i]);
        return;
      }
    }
    System.out.println("해당 번호의 회원이 없습니다.");
  }

  public static void deleteMember() {
    String memberNo = Prompt.inputString("삭제할 회원의 번호? ");
    int targetIndex = -1;
    for (int i = 0; i < length; i++) {
      if (no[i] == Integer.parseInt(memberNo)) {
        targetIndex = i;
        break;
      }
    }
    
    if (targetIndex == -1) {
      System.out.println("해당 번호의 회원이 없습니다.");
      return;
    }

    // 회원 삭제
    for (int i = targetIndex; i < length -1; i++) {
      no[i] = no[i + 1];
      name[i] = name[i + 1];
      email[i] = email[i +1];
      password[i] = password[i + 1];
      gender[i] = gender[i + 1];
    }

    // 마지막 요소 초기화
    no[length -1] = 0;
    name[length -1] = null;
    email[length -1] = null;
    password[length -1] = null;
    gender[length -1] = 0;

    length--; // 회원 수 감소
    System.out.println("회원이 삭제되었습니다.");
  }

  private static char inputGender(char gender) {
    String label;
    if (default == 0) {
      label = "성별?\n";
    } else { 
      label = "성별(" + toGenderString(gender) + ")?\n";
      // label = String.format("성별(%s)?\n", toGenderString(gender));
    }
    loop: while (true) {
      String menuNo = Prompt.inputString(lebel + 
      "  1. 남자\n" + 
      "  2. 여자\n" + 
      "> ");

      switch (menuNo) {
        case "1":
          return MALE;
          break loop;
        case "2":
          return FEMALE;
          break loop;
        default:
          System.out.println("무효한 번호입니다.");
      }
    }
  }

  private static boolean available() {
    return length < MAX_SIZE;
  }
}
