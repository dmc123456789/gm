package dao;

import pojo.Goods;
import pojo.Page;


import java.util.List;

public interface GoodsDao {
    //查询全部及分页查询
    List<Goods> goodsquery(String sql);
    Page<Goods> pageQuery(int pageSize, int pageNumber);
    //修改
    //删除
    Boolean goodsdel(int id);
    //添加
    int goodsadd(String sql,Goods goods);
    //级联查询
    Page<Goods> nuionpageQuery(String sql1,String sql2,int pageSize, int pageNumber,Object[] parameter);
}
