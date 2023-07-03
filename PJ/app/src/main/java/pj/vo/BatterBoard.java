package pj.vo;

import java.io.Serializable;

public class BatterBoard implements Serializable, CsvObject {
  private static final long serialVersionUID = 1L;

  public static int batterBoardNo = 1;

  private int no;
  private String name;
  private String battingAvrg;
  private String rbi;
  private String homerun;
  private int viewCount;
  private long createdDate;

  public BatterBoard() {
    this.no = batterBoardNo++;
    this.createdDate = System.currentTimeMillis();
  }

  public BatterBoard(int no) {
    this.no = no;
  }

  public static BatterBoard fromCsv(String csv) {
    String[] values = csv.split(",");

    BatterBoard batterBoard = new BatterBoard(Integer.parseInt(values[0]));
    batterBoard.setName(values[1]);
    batterBoard.setBattingAvrg(values[2]);
    batterBoard.setRbi(values[3]);
    batterBoard.setHomerun(values[4]);
    batterBoard.setViewCount(Integer.parseInt(values[5]));
    batterBoard.setCreatedDate(Long.parseLong(values[6]));

    if (BatterBoard.batterBoardNo <= batterBoard.getNo()) {
      BatterBoard.batterBoardNo = batterBoard.getNo() + 1;
    }

    return batterBoard;
  }

  @Override
  public String toCsvString() {
    return String.format("%d,%s,%s,%s,%s,%d,%d", this.getNo(), this.getName(),
        this.getBattingAvrg(), this.getRbi(), this.getHomerun(), this.getViewCount(),
        this.getCreatedDate());
  }

  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }

    if (this.getClass() != obj.getClass()) {
      return false;
    }

    BatterBoard b = (BatterBoard) obj;

    if (this.getNo() != b.getNo()) {
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

  public String getBattingAvrg() {
    return battingAvrg;
  }

  public void setBattingAvrg(String battingAvrg) {
    this.battingAvrg = battingAvrg;
  }

  public String getRbi() {
    return rbi;
  }

  public void setRbi(String rbi) {
    this.rbi = rbi;
  }

  public String getHomerun() {
    return homerun;
  }

  public void setHomerun(String homerun) {
    this.homerun = homerun;
  }

  public int getViewCount() {
    return viewCount;
  }

  public void setViewCount(int viewCount) {
    this.viewCount = viewCount;
  }

  public long getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(long createdDate) {
    this.createdDate = createdDate;
  }
}
