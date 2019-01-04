package dao.impl;

import core.util.PageUtil;
import dao.AdminDao;
import pojo.Customer;
import pojo.Page;
import pojo.Superuser;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminDaoImpl extends BaseDao implements AdminDao {
    private static AdminDaoImpl ourInstance = new AdminDaoImpl();

    public static AdminDaoImpl getInstance() {
        return ourInstance;
    }

    private AdminDaoImpl() {
    }

     public List<Superuser> query(String sql) {
            ResultSet rs=getQuery(sql,null);
            List<Superuser> suplist=new ArrayList<Superuser>();
            try {
                while(rs.next()){
                    Superuser sup=new Superuser();
                    sup.setId(rs.getLong("id"));
                    sup.setUserName(rs.getString("userName"));
                    sup.setUserPassword(rs.getString("userImage"));
                    sup.setUserStatus(rs.getInt("userStatus"));
                    sup.setUserId("userID");
                    sup.setUserLoginName(rs.getString("userLoginName"));
                    suplist.add(sup);
                }
                return suplist;
            }catch (SQLException e){
                e.printStackTrace();
            }finally {
                dbClose();
            }
            return null;
        }

        public List<Superuser> query(String sql, Object[] parameter) {
            ResultSet rs=getQuery(sql,parameter);
            List<Superuser> suplist=new ArrayList<Superuser>();
            try {
                while(rs.next()){
                    Superuser sup=new Superuser();
                    sup.setId(rs.getLong("id"));
                    sup.setUserName(rs.getString("userName"));
                    sup.setUserPassword(rs.getString("userImage"));
                    sup.setUserStatus(rs.getInt("userStatus"));
                    sup.setUserId(rs.getString("userID"));
                    sup.setUserLoginName(rs.getString("userLoginName"));
                    suplist.add(sup);
                }
                return suplist;
            }catch (SQLException e){
                e.printStackTrace();
            }finally {
                dbClose();
            }
            return null;
        }

    public List<Customer> cusquery(String sql) {
        ResultSet rs=getQuery(sql,null);
        List<Customer> cuslist=new ArrayList<Customer>();
        try {
            while(rs.next()){
                Customer cus=new Customer();
                cus.setId(rs.getLong("id"));
                cus.setCusName(rs.getString("cusName"));
                cus.setCusLoginName(rs.getString("cusLoginName"));
                cus.setCusPassword(rs.getString("cusPassword"));
                cus.setCusEmail(rs.getString("cusEmail"));
                cus.setCusSex(rs.getString("cusSex"));
                cus.setCusPhoto(rs.getString("cusPhoto"));
                cus.setCusHobby(rs.getString("cusHobby"));
                cus.setCusCode(rs.getString("cusCode"));
                cus.setCusBirthday(rs.getDate("cusBirthday"));
                cuslist.add(cus);
            }
            return cuslist;
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            dbClose();
        }
        return null;
    }

    public List<Customer> cusquery(String sql,Object[] parameter) {
        ResultSet rs=getQuery(sql,parameter);
        List<Customer> cuslist=new ArrayList<Customer>();
        try {
            while(rs.next()){
                Customer cus=new Customer();
                cus.setId(rs.getLong("id"));
                cus.setCusName(rs.getString("cusName"));
                cus.setCusLoginName(rs.getString("cusLoginName"));
                cus.setCusPassword(rs.getString("cusPassword"));
                cus.setCusEmail(rs.getString("cusEmail"));
                cus.setCusSex(rs.getString("cusSex"));
                cus.setCusPhoto(rs.getString("cusPhoto"));
                cus.setCusHobby(rs.getString("cusHobby"));
                cus.setCusCode(rs.getString("cusCode"));
                cus.setCusBirthday(rs.getDate("cusBirthday"));
                cuslist.add(cus);
            }
            return cuslist;
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            dbClose();
        }
        return null;
    }


    public Page<Customer> pageQuery(int pageSize, int pageNumber) {
        Page<Customer> page = new Page<Customer>();
        page.setPageSize(pageSize);
        page.setPageNumber(pageNumber);
        String sql1 = "select count(1) from customer";
        String sql2 = "select * from customer";
        page.setTotalRecode(PageUtil.getTotalRecode(sql1,null));
        List<Customer> cuslist = new ArrayList<Customer>();
        ResultSet rs = PageUtil.getPageDate(sql2,pageSize,pageNumber,null);
        try{
            while(rs.next()){
                Customer cus=new Customer();
                cus.setId(rs.getLong("id"));
                cus.setCusName(rs.getString("cusName"));
                cus.setCusLoginName(rs.getString("cusLoginName"));
                cus.setCusPassword(rs.getString("cusPassword"));
                cus.setCusEmail(rs.getString("cusEmail"));
                cus.setCusSex(rs.getString("cusSex"));
                cus.setCusPhoto(rs.getString("cusPhoto"));
                cus.setCusHobby(rs.getString("cusHobby"));
                cus.setCusCode(rs.getString("cusCode"));
                cus.setCusBirthday(rs.getDate("cusBirthday"));
                cuslist.add(cus);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            dbClose();
        }
        page.setPageDate(cuslist);
        return page;
    }

    public Page<Customer> nuionpageQuery(String sql1, String sql2, int pageSize, int pageNumber, Object[] parameter) {
        Page<Customer> page=new Page<Customer>();
        page.setPageSize(pageSize);
        page.setPageNumber(pageNumber);
        page.setTotalRecode(PageUtil.getTotalRecode(sql1,parameter));
        List<Customer> cuslist=new ArrayList<Customer>();
        ResultSet rs=PageUtil.getPageDate(sql2,pageSize,pageNumber,parameter);
        try{
            while(rs.next()){
                Customer cus=new Customer();
                cus.setId(rs.getLong("id"));
                cus.setCusName(rs.getString("cusName"));
                cus.setCusLoginName(rs.getString("cusLoginName"));
                cus.setCusPassword(rs.getString("cusPassword"));
                cus.setCusEmail(rs.getString("cusEmail"));
                cus.setCusSex(rs.getString("cusSex"));
                cus.setCusPhoto(rs.getString("cusPhoto"));
                cus.setCusHobby(rs.getString("cusHobby"));
                cus.setCusCode(rs.getString("cusCode"));
                cus.setCusBirthday(rs.getDate("cusBirthday"));
                cuslist.add(cus);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            dbClose();
        }
        page.setPageDate(cuslist);
        return page;
    }

    public Boolean delcus(int id) {
        String sql="delete from customer where id=?";
        Object [] parameter={id};
        int num=getUpdate(sql,parameter);
        if (num>0){
            return true;
        }
        return false;
    }

    public int update(String sql, Object[] para) {
        return getUpdate(sql,para);
    }


}
