package pj.vo;

public class Member {

  private static int userId = 1;

  public static final char CATCHER = 'C';
  public static final char PITCHER = 'P';
  public static final char OUTFIELDER = 'O';
  public static final char INFIELDER = 'I';

  public static final String RR = "RR";
  public static final String RL = "RL";
  public static final String LL = "LL";
  public static final String LR = "LR";

  public int no;
  public String name;
  public String dob;
  public char position;
  public String strikeouts;
  public String homerun;
  public String hand;

  public Member() {
    this.no = userId++;
  }


  public int getNo() {
    return no;
  }

  public void setNo(int no) {
    this.no = no;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDob() {
    return dob;
  }

  public void setDob(String dob) {
    this.dob = dob;
  }

  public char getPosition() {
    return position;
  }

  public void setPosition(char position) {
    this.position = position;
  }

  public String getStrikeouts() {
    return strikeouts;
  }

  public void setStrikeouts(String strikeouts) {
    this.strikeouts = strikeouts;
  }

  public String getHomerun() {
    return homerun;
  }

  public void setHomerun(String homerun) {
    this.homerun = homerun;
  }

  public String getHand() {
    return hand;
  }

  public void setHand(String hand) {
    this.hand = hand;
  }


}
