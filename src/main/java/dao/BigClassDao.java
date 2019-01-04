package dao;

import pojo.Bigclass;
import pojo.Customer;
import pojo.Page;

import java.util.List;

public interface BigClassDao {
    //查询所有大分类信息
    List<Bigclass> bigquery(String sql);
    Page<Bigclass> pageQuery(int pageSize, int pageNumber);
    List<Bigclass> query(String sql,Object[] parameter);
    //修改大分类信息
    int update(String sql, Object[] para);
    //添加大分类信息
    int Bigclassadd(String sql, Bigclass  bcs);
    //删除大分类信息
    Boolean delBigclass(int id);
}
