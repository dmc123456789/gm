package service;

import pojo.Goods;
import pojo.Page;
import pojo.Seller;

public interface sellerServiceDao {
    Page<Seller> goodspageQuery(int pageSize, int pageNumber);
    //修改
    //删除
    Boolean delgoods(int id);
    //添加
    int goodsAdd(Seller Seller);
}
