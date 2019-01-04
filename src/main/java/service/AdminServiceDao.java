package service;

import pojo.Customer;
import pojo.Page;
import pojo.Superuser;

import java.util.List;

public interface AdminServiceDao {
    Superuser suoLogin(String loginname,String pwd);
    //查询所有客户信息
    Page<Customer> cusPageQueryAll( int pageSize,int pageNumber);
    //级联查询客户信息
    Page<Customer> cusPageunionQuery(int pageSize,int pageNumber,String Id, String userName, String userSex);
    //删除
    Boolean delcus(int id);
    Superuser QueryByid(int id);
    //修改管理员信息
    int supUpdate(Superuser sup);
    //修改客户信息
    int cusUpdate(Customer cus);

    Customer cusQueryByid(int id);

}
