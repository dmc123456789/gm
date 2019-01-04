package service.impl;

import dao.impl.AdminDaoImpl;
import pojo.Customer;
import pojo.Page;
import pojo.Superuser;
import service.AdminServiceDao;

import javax.jws.Oneway;
import java.util.ArrayList;
import java.util.List;

public class AdminServiceDaoImpl implements AdminServiceDao {
    private static AdminServiceDaoImpl ourInstance = new AdminServiceDaoImpl();

    public static AdminServiceDaoImpl getInstance() {
        return ourInstance;
    }

    private AdminServiceDaoImpl() {
    }

    private AdminDaoImpl adminDao=AdminDaoImpl.getInstance();


    public Superuser suoLogin(String loginname, String pwd) {
        String sql="select * from superuser where userLoginName=? and userPassword=?";
        Object [] parameter={loginname,pwd};
        List<Superuser> suplist=adminDao.query(sql,parameter);
        return suplist.get(0);
    }

    public Page<Customer> cusPageQueryAll( int pageSize,int pageNumber) {
        return adminDao.pageQuery(pageSize,pageNumber);
    }
    //级联查询
    public Page<Customer> cusPageunionQuery(int pageSize,int pageNumber, String Id, String userName, String userSex) {
        int IdSize = Id.length();
        int userNameSize = userName.length();
        int userSexSize = userSex.length();
        if(IdSize == 0 && userNameSize == 0 && userSexSize ==0 ){

            String sql1 = "select count(1) from customer";
            String sql2 = "select * from customer";
            return adminDao.nuionpageQuery(sql1,sql2,pageSize,pageNumber,null);


        }else if(IdSize > 0 && userNameSize == 0 && userSexSize ==0 ){
            //根据id具体查询
            Object []parameter = {Id};
            String sql1="select count(1) from customer where id = ?";
            String sql2 = "select * from customer where id = ?";
            return adminDao.nuionpageQuery(sql1,sql2,pageSize,pageNumber,parameter);
        }else if(IdSize == 0 && userNameSize > 0 && userSexSize ==0){
            //根据姓名模糊查询
            Object []parameter = {"%"+userName+"%"};
            String sql1 = "select count(1) from customer where cusName like ?";
            String sql2 = "select * from customer where cusName like ?";
            return adminDao.nuionpageQuery(sql1,sql2,pageSize,pageNumber,parameter);
        }else if(IdSize == 0 && userNameSize == 0 && userSexSize > 0){
            //根据性别查询
            Object []parameter = {userSex};
            String sql1 = "select count(1) from customer where cusSex = ?";
            String sql2 = "select * from customer where cusSex = ?";
            return adminDao.nuionpageQuery(sql1,sql2,pageSize,pageNumber,parameter);
        }else if(IdSize > 0 && userNameSize > 0 && userSexSize > 0){
            //根据 姓名 学号 性别 级联查询
            Object []parameter = {Id,"%"+userName+"%",userSex};
            String sql1 = "select count(1) from customer where id = ? and cusName like ? and cusSex = ?";
            String sql2 = "select * from customer where id = ? and cusName like ? and cusSex = ?";
            return adminDao.nuionpageQuery(sql1,sql2,pageSize,pageNumber,parameter);
        }else if(IdSize > 0 && userNameSize > 0 && userSexSize == 0){
            //根据 姓名 学号  级联查询
            Object []parameter = {Id,"%"+userName+"%"};
            String sql1 = "select count(1) from customer where id = ? and cusName like ?";
            String sql2 = "select * from customer where id = ? and cusName like ?";
            return adminDao.nuionpageQuery(sql1,sql2,pageSize,pageNumber,parameter);
        }else if(IdSize == 0 && userNameSize > 0 && userSexSize > 0){
            //根据  姓名 性别 级联查询
            Object []parameter = {"%"+userName+"%",userSex};
            String sql1 = "select count(1) from customer where  cusName like ? and cusSex = ?";
            String sql2 = "select * from customer where  cusName like ? and cusSex = ?";
            return adminDao.nuionpageQuery(sql1,sql2,pageSize,pageNumber,parameter);
        }else if(IdSize > 0 && userNameSize == 0 && userSexSize > 0){
            //根据  学号 性别 级联查询
            Object [] parameter = {Id,userSex};
            String sql1 = "select count(1) from customer where id = ? and cusSex = ?";
            String sql2 = "select * from customer where id = ? and cusSex = ?";
            return adminDao.nuionpageQuery(sql1,sql2,pageSize,pageNumber,parameter);
        }
        return null;
    }

    public Boolean delcus(int id) {
        return adminDao.delcus(id);
    }

    public Superuser QueryByid(int id) {
        String sql="select * from superuser where id=?";
        Object [] parameter={id};
        List<Superuser> suplist=adminDao.query(sql,parameter);
        if (suplist!=null&&suplist.size()>0) {
            return suplist.get(0);
        }
        return null;
    }

    public Customer cusQueryByid(int id) {
        String sql="select * from customer where id=?";
        Object [] parameter={id};
        List<Customer> cuslist=adminDao.cusquery(sql,parameter);
        if (cuslist!=null&&cuslist.size()>0) {
            return cuslist.get(0);
        }
        return null;
    }

    public int supUpdate(Superuser sup) {
        String sql="UPDATE superuser SET userStatus=?,userID=?,userLoginName=? where id=?";
        Object [] parameter={sup.getUserStatus(),sup.getUserId(),sup.getUserLoginName(),sup.getId()};
        return adminDao.update(sql,parameter);
    }

    public int cusUpdate(Customer cus) {
        String sql="update customer set cusLoginName=?,cusEmail=?,cusSex=?,cusHobby=?,cusCode=?,cusBirthday=? where id=?";
        Object[] parameter={cus.getCusLoginName(),cus.getCusEmail(),cus.getCusSex(),cus.getCusHobby(),cus.getCusCode(),cus.getCusBirthday(),cus.getId()};
        return adminDao.update(sql,parameter);
    }


}
