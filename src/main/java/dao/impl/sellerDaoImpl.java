package dao.impl;

import core.util.PageUtil;
import dao.sellerDao;

import pojo.Page;
import pojo.Seller;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * ClassName dao.impl
 *
 * @Author dmc
 * @Date 2019/1/2 11:05
 * @Version V1.0
 **/
public class sellerDaoImpl extends BaseDao implements sellerDao {
    private static sellerDaoImpl ourInstance = new sellerDaoImpl();

    public static sellerDaoImpl getInstance() {
        return ourInstance;
    }

    private sellerDaoImpl() {
    }

    public List<Seller> goodsquery(String sql) {
        ResultSet rs = getQuery(sql, null);
        List<Seller> alist = new ArrayList<Seller>();
        try {
            while (rs.next()) {
                Seller s = new Seller();
                  s.setId(rs.getLong("id"));
                  s.setSellerName(rs.getString("sellerName"));
                  s.setSellerUser(rs.getString("sellerUser"));
                  s.setSellerPassword(rs.getString("sellerPassword"));
                  s.setSellerSex(rs.getString("sellerSex"));
                  s.setSellerBirthday(rs.getDate("sellerBirthday"));
                  s.setSellerIdCard(rs.getString("selerIdCard"));
                  s.setSellerEmail(rs.getString("sellerEmail"));
                  s.setSellerTel(rs.getString("sellerTel"));
                  s.setSellerAddress(rs.getString("sellerAddress"));
                  alist.add(s);
            }
            return alist;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbClose();
        }
        return null;
    }

    public Page<Seller> pageQuery(int pageSize, int pageNumber) {
        Page<Seller> smallpage = new Page<Seller>();
        smallpage.setPageSize(pageSize);
        smallpage.setPageNumber(pageNumber);
        String sql1 = "select count(1) from Seller";
        String sql2 = "select * from Seller";
        smallpage.setTotalRecode(PageUtil.getTotalRecode(sql1, null));
        List<Seller> sList = new ArrayList<Seller>();
        ResultSet rs = PageUtil.getPageDate(sql2, pageSize, pageNumber, null);
        try {
            while (rs.next()) {
                Seller s = new Seller();
                s.setId(rs.getLong("id"));
                s.setSellerName(rs.getString("sellerName"));
                s.setSellerUser(rs.getString("sellerUser"));
                s.setSellerPassword(rs.getString("sellerPassword"));
                s.setSellerSex(rs.getString("sellerSex"));
                s.setSellerBirthday(rs.getDate("sellerBirthday"));
                s.setSellerIdCard(rs.getString("sellerIdCard"));
                s.setSellerEmail(rs.getString("sellerEmail"));
                s.setSellerTel(rs.getString("sellerTel"));
                s.setSellerAddress(rs.getString("sellerAddress"));
                sList.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbClose();
        }
        smallpage.setPageDate(sList);
        return smallpage;
    }

    public Boolean goodsdel(int id) {
        String sql = "delete from sellerh where id=?";
        Object[] parameter = {id};
        int num = getUpdate(sql, parameter);
        if (num > 0) {
            return true;
        }
        return false;
    }

    public int goodsadd(String sql, Seller s) {
        Object []parameter={s.getSellerName(),s.getSellerUser(),s.getSellerPassword(),s.getSellerSex(),s.getSellerBirthday(),
                s.getSellerIdCard(),s.getSellerEmail(),s.getSellerTel(),s.getSellerAddress()};
        return getUpdate(sql,parameter);
    }
}
