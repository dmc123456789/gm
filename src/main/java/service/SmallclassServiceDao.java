package service;

import pojo.Bigclass;
import pojo.Customer;
import pojo.Page;
import pojo.Smallclass;

import java.util.List;

public interface SmallclassServiceDao {
    //查询全部及分页查询
    Page<Smallclass> smallclasspageQuery(int pageSize, int pageNumber);
    //修改
    //删除
    Boolean delSmallclass(int id);
    //添加
    int SmaclassAdd(Smallclass sma);
    //级联查询
    Page<Smallclass> SmaPageunionQuery(int pageSize, int pageNumber, String Id, String smallName);
}

