package pojo;


/**
 * ClassName pojo
 *
 * @Author dmc
 * @Date 2019/1/4 9:22
 * @Version V1.0
 **/
public class Extorderse extends Orderse {
   private Seller seller;
   private Goods goods;
   private Customer customer;

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Extorderse() {
    }

    public Extorderse(Seller seller, Goods goods, Customer customer) {
        this.seller = seller;
        this.goods = goods;
        this.customer = customer;
    }
}
