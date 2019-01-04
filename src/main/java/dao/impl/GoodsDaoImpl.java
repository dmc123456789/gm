package dao.impl;

import core.util.PageUtil;
import dao.GoodsDao;
import pojo.Goods;
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
 * @Date 2019/1/1 23:19
 * @Version V1.0
 **/
public class GoodsDaoImpl extends BaseDao implements GoodsDao {
    private static GoodsDaoImpl ourInstance = new GoodsDaoImpl();

    public static GoodsDaoImpl getInstance() {
        return ourInstance;
    }

    private GoodsDaoImpl() {
    }
      //查询所有
    public List<Goods> goodsquery(String sql) {
        ResultSet rs = getQuery(sql, null);
        List<Goods> glist = new ArrayList<Goods>();
        try {
            while (rs.next()) {
                Goods g = new Goods();
                g.setId(rs.getLong("id"));
                g.setGoodsName(rs.getString("goodsName"));
                g.setGoodsSmalId(rs.getLong("goodsSmalId"));
                g.setGoodsMoney(rs.getDouble("goodsMoney"));
                g.setGoodsNumber(rs.getLong("goodsNumber"));
                g.setGoodsImage(rs.getString("goodsImage"));
                g.setGoodsCarriage(rs.getDouble("goodsCarriage"));
                g.setGoodsType(rs.getLong("goodsType"));
                g.setGoodsDiscId(rs.getLong("goodsDiscId"));
                glist.add(g);
            }
            return glist;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbClose();
        }

        return null;
    }
  //分页
    public Page<Goods> pageQuery(int pageSize, int pageNumber) {
        Page<Goods> smallpage = new Page<Goods>();
        smallpage.setPageSize(pageSize);
        smallpage.setPageNumber(pageNumber);
        String sql1 = "select count(1) from goods";
        String sql2 = "select * from goods";
        smallpage.setTotalRecode(PageUtil.getTotalRecode(sql1, null));
        List<Goods> goodsList = new ArrayList<Goods>();
        ResultSet rs = PageUtil.getPageDate(sql2, pageSize, pageNumber, null);
        try {
            while (rs.next()) {
                Goods g = new Goods();
                g.setId(rs.getLong("id"));
                g.setGoodsName(rs.getString("goodsName"));
                g.setGoodsSmalId(rs.getLong("goodsSmalId"));
                g.setGoodsMoney(rs.getDouble("goodsMoney"));
                g.setGoodsNumber(rs.getLong("goodsNumber"));
                g.setGoodsImage(rs.getString("goodsImage"));
                g.setGoodsCarriage(rs.getDouble("goodsCarriage"));
                g.setGoodsType(rs.getLong("goodsType"));
                g.setGoodsDiscId(rs.getLong("goodsDiscId"));
                goodsList.add(g);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbClose();
        }
        smallpage.setPageDate(goodsList);
        return smallpage;
    }
    //删除
    public Boolean goodsdel(int id) {
        String sql = "delete from goods where id=?";
        Object[] parameter = {id};
        int num = getUpdate(sql, parameter);
        if (num > 0) {
            return true;
        }
        return false;

    }
   //添加
    public int goodsadd(String sql, Goods goods) {
        Object []parameter={goods.getGoodsName(),goods.getGoodsSmalId(),
                goods.getGoodsMoney(),goods.getGoodsNumber(),goods.getGoodsImage(),
                goods.getGoodsCarriage(),goods.getGoodsType(),goods.getGoodsDiscId()};
        return getUpdate(sql,parameter);
    }
    //分页级联查询
    public Page<Goods> nuionpageQuery(String sql1, String sql2, int pageSize, int pageNumber, Object[] parameter) {
        Page<Goods> page = new Page<Goods>();
        page.setPageSize(pageSize);
        page.setPageNumber(pageNumber);
        page.setTotalRecode(PageUtil.getTotalRecode(sql1, parameter));
        List<Goods> goods = new ArrayList<Goods>();
        ResultSet rs = PageUtil.getPageDate(sql2, pageSize, pageNumber, parameter);
        try {
            while (rs.next()) {
      Goods g=new Goods();
                g.setId(rs.getLong("id"));
                g.setGoodsName(rs.getString("goodsName"));
                g.setGoodsSmalId(rs.getLong("goodsSmalId"));
                g.setGoodsMoney(rs.getDouble("goodsMoney"));
                g.setGoodsNumber(rs.getLong("goodsNumber"));
                g.setGoodsImage(rs.getString("goodsImage"));
                g.setGoodsCarriage(rs.getDouble("goodsCarriage"));
                g.setGoodsType(rs.getLong("goodsType"));
                g.setGoodsDiscId(rs.getLong("goodsDiscId"));
                goods.add(g);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbClose();
        }
        page.setPageDate(goods);
        return page;
    }
}
