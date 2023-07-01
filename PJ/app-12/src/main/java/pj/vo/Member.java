package pj.vo;

public class Member {

  // 모든 인스턴스가 공유하는 값은 스태틱 필드에 보관한다.
  private static int userId = 1;

  // 상수는 스태틱 필드로 정의한다.
  // 정보를 다룰 때는 그 정보를 갖고 있는 클래스에 그 기능을 둔다.
  // 필드도 마찬가지이다.
  // => GRASP 패턴: Information Expert
  public static final char LEFT = 'L';
  public static final char RIGHT = 'R';
  public static final char PITCHER = 'P';
  public static final char BATTER = 'B';

  // 인스턴스 필드는 각각 개별적으로 유지해야 하는 값을 저장할 때 사용한다.
  // new 명령을 통해 변수를 Heap 영역에 생성한다.
  public int no;
  public String name;
  public char position;
  public String strikeOuts;
  public String homeRuns;
  public char hand;

  // 생성자는 인스턴스를 생성한 후 필드를 초기화시키는 일을 한다.
  // 인스턴스를 사용할 때 문제가 없도록 유효한 값으로 초기화시킨다.
  // 기본 생성자(default constructor)는 개발자가 생성자를 정의하지 않을 때
  // 컴파일러가 추가해주는 생성자다.
  // 물론 개발자가 직접 추가할 수도 있다.
  public Member() {
    this.no = userId++;
  }

  // getter/setter는 인스턴스 필드의 값을 설정하고 꺼내는 메서드다.
  // 보통 외부에서 직접 필드에 접근하는 것을 막았을 때 사용한다.
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

  public char getPosition() {
    return position;
  }

  public void setPosition(char position) {
    this.position = position;
  }

  public String getStrikeOuts() {
    return strikeOuts;
  }

  public void setStrikeOuts(String strikeOuts) {
    this.strikeOuts = strikeOuts;
  }

  public String getHomeRuns() {
    return homeRuns;
  }

  public void setHomeRuns(String homeRuns) {
    this.homeRuns = homeRuns;
  }

  public char getHand() {
    return hand;
  }

  public void setHand(char hand) {
    this.hand = hand;
  }

}