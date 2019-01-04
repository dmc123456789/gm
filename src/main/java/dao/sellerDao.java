package dao;

import pojo.Announcement;
import pojo.Page;
import pojo.Seller;

import java.util.List;

public interface sellerDao {
    //查询全部及分页查询
    List<Seller> goodsquery(String sql);
    Page<Seller> pageQuery(int pageSize, int pageNumber);
    //修改
    //删除
    Boolean goodsdel(int id);
    //添加
    int goodsadd(String sql,Seller s);
}
