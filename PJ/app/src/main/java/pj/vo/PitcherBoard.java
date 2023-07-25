package pj.vo;

import java.io.Serializable;

public class PitcherBoard implements Serializable, CsvObject {
  private static final long serialVersionUID = 1L;

  public static int pitcherBoardNo = 1;

  private int no;
  private String name;
  private String era;
  private String strikeOut;
  private String whip;
  private int viewCount;
  private long createdDate;

  public PitcherBoard() {
    this.no = pitcherBoardNo++;
    this.createdDate = System.currentTimeMillis();
  }

  public PitcherBoard(int no) {
    this.no = no;
  }

  public static PitcherBoard fromCsv(String csv) {
    String[] values = csv.split(",");

    PitcherBoard pitcherBoard = new PitcherBoard(Integer.parseInt(values[0]));
    pitcherBoard.setName(values[1]);
    pitcherBoard.setEra(values[2]);
    pitcherBoard.setStrikeOut(values[3]);
    pitcherBoard.setWhip(values[4]);
    pitcherBoard.setViewCount(Integer.parseInt(values[5]));
    pitcherBoard.setCreatedDate(Long.parseLong(values[6]));

    if (PitcherBoard.pitcherBoardNo <= pitcherBoard.getNo()) {
      PitcherBoard.pitcherBoardNo = pitcherBoard.getNo() + 1;
    }

    return pitcherBoard;
  }

  @Override
  public String toCsvString() {
    return String.format("%d,%s,%s,%s,%s,%d,%d", this.getNo(), this.getName(), this.getEra(),
        this.getStrikeOut(), this.getWhip(), this.getViewCount(), this.getCreatedDate());
  }

  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }

    if (this.getClass() != obj.getClass()) {
      return false;
    }

    PitcherBoard b = (PitcherBoard) obj;

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

  public String getEra() {
    return era;
  }

  public void setEra(String era) {
    this.era = era;
  }

  public String getStrikeOut() {
    return strikeOut;
  }

  public void setStrikeOut(String strikeOut) {
    this.strikeOut = strikeOut;
  }

  public String getWhip() {
    return whip;
  }

  public void setWhip(String whip) {
    this.whip = whip;
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
