package dao.impl;

import core.util.PageUtil;
import dao.orderseDao;
import pojo.*;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * ClassName dao.impl
 *
 * @Author dmc
 * @Date 2019/1/4 9:48
 * @Version V1.0
 **/
public class orderseDaoImpl extends BaseDao  implements orderseDao {
    private static orderseDaoImpl ourInstance = new orderseDaoImpl();

    public static orderseDaoImpl getInstance() {
        return ourInstance;
    }

    private orderseDaoImpl() {
    }
    /**
     * 查询订单
     * @param sql
     * @return
     */
    public List<Extorderse> query(String sql) {
        ResultSet rs = getQuery(sql, null);
        List<Extorderse>list=new ArrayList<Extorderse>();
         try{
             while (rs.next()){
           Extorderse e=new Extorderse();
                 Seller s=new Seller();
                 Goods g=new Goods();
                 Customer c=new Customer();
                 s.setSellerName(rs.getString("sellerName"));
                 g.setGoodsName(rs.getString("goodsName"));
                 c.setCusName(rs.getString("cusName"));
                 e.setSeller(s);
                 e.setCustomer(c);
                 e.setGoods(g);
                e.setId(rs.getLong("id"));
                e.setOrderseId(rs.getLong("orderseId"));
                e.setOrderseGoodsId(rs.getLong("orderseGoodsId"));
                e.setOrderseCusId(rs.getLong("orderseCusId"));
                e.setOrderseDate(rs.getDate("orderseDate"));
                e.setOrderseAddress(rs.getString("orderseAddress"));
                e.setOrderseMoney(rs.getDouble("orderseMoney"));
                e.setOrderseStatus(rs.getLong("orderseStatus"));
                  list.add(e);
             }
             return list;
         }catch (Exception e){
         e.printStackTrace();
         }finally {
             dbClose();
         }
         return null;
    }

    public Page<Extorderse> pageQuery(int pageSize, int pageNumber) {
        Page<Extorderse> extordersePage = new Page<Extorderse>();
        extordersePage.setPageSize(pageSize);
        extordersePage.setPageNumber(pageNumber);
        String sql1="";
        String sql2="";
        extordersePage.setTotalRecode(PageUtil.getTotalRecode(sql1,null));
        List<Extorderse>list=new ArrayList<Extorderse>();
        ResultSet rs = PageUtil.getPageDate(sql2, pageSize, pageNumber, null);
       try {
           while (rs.next()){
               Extorderse e=new Extorderse();
               Seller s=new Seller();
               Goods g=new Goods();
               Customer c=new Customer();
               s.setSellerName(rs.getString("sellerName"));
               g.setGoodsName(rs.getString("goodsName"));
               c.setCusName(rs.getString("cusName"));
               e.setSeller(s);
               e.setCustomer(c);
               e.setGoods(g);
               e.setId(rs.getLong("id"));
               e.setOrderseId(rs.getLong("orderseId"));
               e.setOrderseGoodsId(rs.getLong("orderseGoodsId"));
               e.setOrderseCusId(rs.getLong("orderseCusId"));
               e.setOrderseDate(rs.getDate("orderseDate"));
               e.setOrderseAddress(rs.getString("orderseAddress"));
               e.setOrderseMoney(rs.getDouble("orderseMoney"));
               e.setOrderseStatus(rs.getLong("orderseStatus"));
               list.add(e);
           }
       }catch (Exception e){
           e.printStackTrace();
       }finally {
           dbClose();
       }
        extordersePage.setPageDate(list);
      return extordersePage;
    }
}
