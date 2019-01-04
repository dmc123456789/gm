package pojo;


public class Goods {

  private long id;
  private String goodsName;
  private long goodsSmalId;
  private double goodsMoney;
  private long goodsNumber;
  private String goodsImage;
  private double goodsCarriage;
  private long goodsType;
  private long goodsDiscId;

    public Goods(int id2, String goodsName, long goodsSmalId, double goodsMoney, long goodsNumber, Object o, double goodsCarriage, long goodsType, long goodsDiscId) {
    }

    public Goods() {
    }

    public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getGoodsName() {
    return goodsName;
  }

  public void setGoodsName(String goodsName) {
    this.goodsName = goodsName;
  }


  public long getGoodsSmalId() {
    return goodsSmalId;
  }

  public void setGoodsSmalId(long goodsSmalId) {
    this.goodsSmalId = goodsSmalId;
  }


  public double getGoodsMoney() {
    return goodsMoney;
  }

  public void setGoodsMoney(double goodsMoney) {
    this.goodsMoney = goodsMoney;
  }


  public long getGoodsNumber() {
    return goodsNumber;
  }

  public void setGoodsNumber(long goodsNumber) {
    this.goodsNumber = goodsNumber;
  }


  public String getGoodsImage() {
    return goodsImage;
  }

  public void setGoodsImage(String goodsImage) {
    this.goodsImage = goodsImage;
  }


  public double getGoodsCarriage() {
    return goodsCarriage;
  }

  public void setGoodsCarriage(double goodsCarriage) {
    this.goodsCarriage = goodsCarriage;
  }


  public long getGoodsType() {
    return goodsType;
  }

  public void setGoodsType(long goodsType) {
    this.goodsType = goodsType;
  }


  public long getGoodsDiscId() {
    return goodsDiscId;
  }

  public void setGoodsDiscId(long goodsDiscId) {
    this.goodsDiscId = goodsDiscId;
  }

}
