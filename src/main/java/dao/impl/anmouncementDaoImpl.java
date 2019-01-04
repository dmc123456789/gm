package dao.impl;

import core.util.PageUtil;
import dao.announcementDao;
import pojo.Announcement;
import pojo.Goods;
import pojo.Page;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * ClassName dao.impl
 *
 * @Author dmc
 * @Date 2019/1/2 10:05
 * @Version V1.0
 **/
public class anmouncementDaoImpl extends BaseDao implements announcementDao {
    private static anmouncementDaoImpl ourInstance = new anmouncementDaoImpl();

    public static anmouncementDaoImpl getInstance() {
        return ourInstance;
    }

    private anmouncementDaoImpl() {
    }
    //查询所有
    public List<Announcement> goodsquery(String sql) {
        ResultSet rs = getQuery(sql, null);
        List<Announcement> alist = new ArrayList<Announcement>();
        try {
            while (rs.next()) {
                Announcement a = new Announcement();
                 a.setId(rs.getLong("id"));
                 a.setAaTitle(rs.getString("aTitle"));
                 a.setAaText(rs.getString("aText"));
                 a.setAaDate(rs.getDate("aDate"));
                alist.add(a);
            }
            return alist;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbClose();
        }

        return null;
    }
    //分页查询
    public Page<Announcement> pageQuery(int pageSize, int pageNumber) {
        Page<Announcement> smallpage = new Page<Announcement>();
        smallpage.setPageSize(pageSize);
        smallpage.setPageNumber(pageNumber);
        String sql1 = "select count(1) from announcement";
        String sql2 = "select * from announcement";
        smallpage.setTotalRecode(PageUtil.getTotalRecode(sql1, null));
        List<Announcement> aList = new ArrayList<Announcement>();
        ResultSet rs = PageUtil.getPageDate(sql2, pageSize, pageNumber, null);
        try {
            while (rs.next()) {
       Announcement a=new Announcement();
                a.setId(rs.getLong("id"));
                a.setAaTitle(rs.getString("aTitle"));
                a.setAaText(rs.getString("aText"));
                a.setAaDate(rs.getDate("aDate"));
                aList.add(a);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbClose();
        }
        smallpage.setPageDate(aList);
        return smallpage;
    }
      //删除
    public Boolean goodsdel(int id) {
        String sql = "delete from announcement where id=?";
        Object[] parameter = {id};
        int num = getUpdate(sql, parameter);
        if (num > 0) {
            return true;
        }
        return false;
    }
   //添加
    public int goodsadd(String sql, Announcement a) {
        Object []parameter={a.getId(),a.getAaTitle(),a.getAaText(),a.getAaDate()};
        return getUpdate(sql,parameter);
    }
}
