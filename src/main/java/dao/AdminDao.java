package dao;

import pojo.Customer;
import pojo.Page;
import pojo.Superuser;

import java.util.List;

public interface AdminDao {
    List<Superuser> query(String sql);

    List<Superuser> query(String sql,Object[] parameter);

    List<Customer> cusquery(String sql);
   //分页查询
    Page<Customer> pageQuery(int pageSize, int pageNumber);
  //分页级联查询
    Page<Customer> nuionpageQuery(String sql1,String sql2,int pageSize, int pageNumber,Object[] parameter);

    Boolean delcus(int id);
     //修改
    int update(String sql, Object[] para);


    public List<Customer> cusquery(String sql,Object[] parameter);
}
