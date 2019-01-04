package dao;

import pojo.Page;
import pojo.Smallclass;

import java.util.List;

public interface SmallclassDao {
  //查询全部及分页查询
    List<Smallclass> smallquery(String sql);
    Page<Smallclass> pageQuery(int pageSize, int pageNumber);
   //修改
   //删除
   Boolean delSmallclass(int id);
    //添加
   int smallclassadd(String sql,Smallclass sma);
   //级联查询
   Page<Smallclass> nuionpageQuery(String sql1,String sql2,int pageSize, int pageNumber,Object[] parameter);
}
