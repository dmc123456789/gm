package dao.impl;

import core.util.PageUtil;
import dao.SmallclassDao;

import pojo.Page;
import pojo.Smallclass;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * ClassName dao.impl
 *
 * @Author dmc
 * @Date 2018/12/30 18:37
 * @Version V1.0
 **/
public class SmallclassDaoImpl extends BaseDao implements SmallclassDao {
    private static SmallclassDaoImpl ourInstance = new SmallclassDaoImpl();

    public static SmallclassDaoImpl getInstance() {
        return ourInstance;
    }

    private SmallclassDaoImpl() {
    }

    //查询所有
    public List<Smallclass> smallquery(String sql) {
        ResultSet rs = getQuery(sql, null);
        List<Smallclass> smalllist = new ArrayList<Smallclass>();
        try {
            while (rs.next()) {
                Smallclass s = new Smallclass();
                s.setId(rs.getLong("id"));
                s.setSmallName(rs.getString("smallName"));
                s.setSmallBigId(rs.getLong("smallBigId"));
                s.setSmallText(rs.getString("smallText"));
                smalllist.add(s);
            }
            return smalllist;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbClose();
        }

        return null;
    }

    //分页查询
    public Page<Smallclass> pageQuery(int pageSize, int pageNumber) {
        Page<Smallclass> smallpage = new Page<Smallclass>();
        smallpage.setPageSize(pageSize);
        smallpage.setPageNumber(pageNumber);
        String sql1 = "select count(1) from smallclass";
        String sql2 = "select * from smallclass";
        smallpage.setTotalRecode(PageUtil.getTotalRecode(sql1, null));
        List<Smallclass> SmallclassList = new ArrayList<Smallclass>();
        ResultSet rs = PageUtil.getPageDate(sql2, pageSize, pageNumber, null);
        try {
            while (rs.next()) {
                Smallclass s = new Smallclass();
                s.setId(rs.getLong("id"));
                s.setSmallName(rs.getString("smallName"));
                s.setSmallBigId(rs.getLong("smallBigId"));
                s.setSmallText(rs.getString("smallText"));
                SmallclassList.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbClose();
        }
        smallpage.setPageDate(SmallclassList);
        return smallpage;
    }

    //删除
    public Boolean delSmallclass(int id) {
        String sql = "delete from smallclass where id=?";
        Object[] parameter = {id};
        int num = getUpdate(sql, parameter);
        if (num > 0) {
            return true;
        }
        return false;

    }

    //添加
    public int smallclassadd(String sql, Smallclass sma) {
        Object []parameter={sma.getSmallName(),sma.getSmallBigId(),sma.getSmallText()};
        return getUpdate(sql,parameter);
    }

    //分页级联查询
    public Page<Smallclass> nuionpageQuery(String sql1, String sql2, int pageSize, int pageNumber, Object[] parameter) {
        Page<Smallclass> page = new Page<Smallclass>();
        page.setPageSize(pageSize);
        page.setPageNumber(pageNumber);
        page.setTotalRecode(PageUtil.getTotalRecode(sql1, parameter));
        List<Smallclass> smalist = new ArrayList<Smallclass>();
        ResultSet rs = PageUtil.getPageDate(sql2, pageSize, pageNumber, parameter);
        try {
            while (rs.next()) {
                Smallclass cus = new Smallclass();
                cus.setId(rs.getLong("id"));
                cus.setSmallName(rs.getString("smallName"));
                cus.setSmallBigId(rs.getLong("smallBigId"));
                cus.setSmallText(rs.getString("smallText"));
                smalist.add(cus);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbClose();
        }
        page.setPageDate(smalist);
        return page;
    }
}