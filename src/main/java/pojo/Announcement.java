package pojo;

import java.sql.Date;

public class Announcement {

  private long id;
  private String aaTitle;
  private String aaText;

  public Announcement() {
  }

  public Announcement(long id, String aaTitle, String aaText, Date aaDate) {
    this.id = id;
    this.aaTitle = aaTitle;
    this.aaText = aaText;
    this.aaDate = aaDate;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getAaTitle() {
    return aaTitle;
  }

  public void setAaTitle(String aaTitle) {
    this.aaTitle = aaTitle;
  }

  public String getAaText() {
    return aaText;
  }

  public void setAaText(String aaText) {
    this.aaText = aaText;
  }

  public Date getAaDate() {
    return aaDate;
  }

  public void setAaDate(Date aaDate) {
    this.aaDate = aaDate;
  }

  private java.sql.Date aaDate;


}