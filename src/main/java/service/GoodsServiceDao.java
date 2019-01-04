package service;

import pojo.Goods;
import pojo.Page;

public interface GoodsServiceDao {
    //查询全部及分页查询
    Page<Goods> goodspageQuery(int pageSize, int pageNumber);
    //修改
    //删除
    Boolean delgoods(int id);
    //添加
    int goodsAdd(Goods goods);
    //级联查询
    Page<Goods> goodsPageunionQuery(int pageSize, int pageNumber, String Id, String goodsName);
}
