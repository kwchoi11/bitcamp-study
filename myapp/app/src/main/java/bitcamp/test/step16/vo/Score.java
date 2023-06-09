package bitcamp.test.step16.vo;

public class Score {
  public String name;
  public int kor;
  public int eng;
  public int math;
  public int sum;
  public float aver;

  public Score(String name, int kor, int eng, int math) {
    this.name = name;
    this.kor = kor;
    this.eng = eng;
    this.math = math;
    this.compute();
  }

  void compute() {
    this.sum = this.kor + this.eng + this.math;
    this.aver = this.sum / 3f;
  }


  // getter: private 으로 접근이 막힌 변수의 값을 리턴해 주는 메서드.
  public int getSum() {
    return this.sum;
  }

  public float getAver() {
    return this.aver;
  }

  public String getName() {
    return this.name;
  }

}