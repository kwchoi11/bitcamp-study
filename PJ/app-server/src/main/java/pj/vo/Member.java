package pj.vo;

import java.io.Serializable;

public class Member implements Serializable, CsvObject {
  private static final long serialVersionUID = 1L;

  public static int userId = 1;

  public static final char CATCHER = 'C';
  public static final char PITCHER = 'P';
  public static final char INFIELDER = 'I';
  public static final char OUTFIELDER = 'O';

  private int no;
  private String name;
  private String birthday;
  private String height;
  private String weight;
  private String career;
  private String hand;
  private char position;

  public Member() {
    this.no = userId++;
  }

  public Member(int no) {
    this.no = no;
  }

  public static Member fromCsv(String csv) {
    String[] values = csv.split(",");

    Member member = new Member(Integer.parseInt(values[0]));
    member.setName(values[1]);
    member.setBirthday(values[2]);
    member.setHeight(values[3]);
    member.setWeight(values[4]);
    member.setCareer(values[5]);
    member.setHand(values[6]);
    member.setPosition(values[7].charAt(0));

    if (Member.userId <= member.getNo()) {
      Member.userId = member.getNo() + 1;
    }

    return member;
  }

  @Override
  public String toCsvString() {
    return String.format("%d,%s,%s,%s,%s,%s,%s,%c", this.getNo(), this.getName(),
        this.getBirthday(), this.getHeight(), this.getWeight(), this.getCareer(), this.getHand(),
        this.getPosition());
  }

  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    if (this.getClass() != obj.getClass()) {
      return false;
    }
    Member m = (Member) obj;
    if (this.getNo() != m.getNo()) {
      return false;
    }
    return true;
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

  public String getBirthday() {
    return birthday;
  }

  public void setBirthday(String birthday) {
    this.birthday = birthday;
  }

  public String getHeight() {
    return height;
  }

  public void setHeight(String height) {
    this.height = height;
  }

  public String getWeight() {
    return weight;
  }

  public void setWeight(String weight) {
    this.weight = weight;
  }

  public String getCareer() {
    return career;
  }

  public void setCareer(String career) {
    this.career = career;
  }

  public String getHand() {
    return hand;
  }

  public void setHand(String hand) {
    this.hand = hand;
  }

  public char getPosition() {
    return position;
  }

  public void setPosition(char position) {
    this.position = position;
  }

}
