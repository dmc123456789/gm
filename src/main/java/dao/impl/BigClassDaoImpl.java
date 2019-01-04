package dao.impl;

import core.util.PageUtil;
import dao.BigClassDao;
import pojo.Bigclass;

import pojo.Page;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * ClassName dao.impl
 *
 * @Author dmc
 * @Date 2018/12/29 14:45
 * @Version V1.0
 **/
public class BigClassDaoImpl extends BaseDao implements BigClassDao {
    private static BigClassDaoImpl ourInstance = new BigClassDaoImpl();
    public static BigClassDaoImpl getInstance() {
        return ourInstance;
    }

    private BigClassDaoImpl() {
    }

    /**
     *
     *查询所有大分类信息
     * */
    public List<Bigclass> bigquery(String sql) {
        ResultSet rs=getQuery(sql,null);
        List<Bigclass> biglist=new ArrayList<Bigclass>();
        try{
            while (rs.next()){
           Bigclass bc=new Bigclass();
             bc.setId(rs.getLong("id"));
             bc.setBigName(rs.getString("BigName"));
             bc.setBigText(rs.getString("BigText"));
                biglist.add(bc);
            }
            return biglist;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            dbClose();
        }
        return null;
    }

    /**
     * 分页查询
     */
    public Page<Bigclass> pageQuery(int pageSize, int pageNumber) {
        Page<Bigclass> bigpage = new Page<Bigclass>();
        bigpage.setPageSize(pageSize);
        bigpage.setPageNumber(pageNumber);
        String sql1 = "select count(1) from bigclass";
        String sql2 = "select * from bigclass";
        bigpage.setTotalRecode(PageUtil.getTotalRecode(sql1,null));
        List<Bigclass> bigclassList = new ArrayList<Bigclass>();
        ResultSet rs = PageUtil.getPageDate(sql2,pageSize,pageNumber,null);
         try{
             while (rs.next()){
            Bigclass bc=new Bigclass();
            bc.setId(rs.getLong("id"));
            bc.setBigName(rs.getString("bigName"));
            bc.setBigText(rs.getString("bigText"));
                 bigclassList.add(bc);
             }
         }catch (Exception e){
             e.printStackTrace();
         }finally {
             dbClose();
         }
        bigpage.setPageDate(bigclassList);
    return bigpage;
    }

    public List<Bigclass> query(String sql, Object[] parameter) {
        ResultSet rs=getQuery(sql,parameter);
        List<Bigclass> cuslist=new ArrayList<Bigclass>();
        try {
            while(rs.next()){
                Bigclass big=new Bigclass();
                 big.setId(rs.getLong("id"));
                 big.setBigName(rs.getString("bigName"));
                 big.setBigText(rs.getString("bigText"));
                cuslist.add(big);
            }
            return cuslist;
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            dbClose();
        }
        return null;
    }
    /**
     * 修改
     * @return
     */
    public int update(String sql, Object[] para) {
        return getUpdate(sql,para);
    }
    /**
     * 添加
     */
    public int Bigclassadd(String sql, Bigclass bcs) {
        Object []parameter={bcs.getBigName(),bcs.getBigText()};
        return  getUpdate(sql,parameter);
    }

    /**
     * 删除
     */
    public Boolean delBigclass(int id) {
        String sql="delete from bigclass where id=?";
        Object [] parameter={id};
        int num=getUpdate(sql,parameter);
        if (num>0){
            return true;
        }
        return false;
    }
}
