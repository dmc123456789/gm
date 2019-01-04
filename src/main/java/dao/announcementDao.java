package dao;

import pojo.Announcement;
import pojo.Goods;
import pojo.Page;

import java.util.List;

/**
 * ClassName dao
 *
 * @Author dmc
 * @Date 2019/1/2 10:02
 * @Version V1.0
 **/
public interface announcementDao {
    //查询全部及分页查询
    List<Announcement> goodsquery(String sql);
    Page<Announcement> pageQuery(int pageSize, int pageNumber);
    //修改
    //删除
    Boolean goodsdel(int id);
    //添加
    int goodsadd(String sql,Announcement a);
}

