package service.impl;

import dao.impl.GoodsDaoImpl;
import pojo.Goods;
import pojo.Page;
import service.GoodsServiceDao;

/**
 * ClassName service.impl
 *
 * @Author dmc
 * @Date 2019/1/1 23:30
 * @Version V1.0
 **/
public class GoodsServiceDaoImpl implements GoodsServiceDao {
    private static GoodsServiceDaoImpl ourInstance = new GoodsServiceDaoImpl();
    public static GoodsServiceDaoImpl getInstance() {
        return ourInstance;
    }
    private GoodsServiceDaoImpl() {
    }
    private GoodsDaoImpl goodsDao= GoodsDaoImpl.getInstance();


    public Page<Goods> goodspageQuery(int pageSize, int pageNumber) {

        return goodsDao.pageQuery(pageSize,pageNumber);
    }

    public Boolean delgoods(int id) {
        return goodsDao.goodsdel(id);
    }

    public int goodsAdd(Goods goods) {
        String sql="insert into goods (goodsName,goodsSmalId,goodsMoney,goodsNumber,goodsImage,goodsCarriage,goodsType,goodsDiscld) values(?,?,?,?,null,?,?,?)";
        return goodsDao.goodsadd(sql,goods);
    }

    public Page<Goods> goodsPageunionQuery(int pageSize, int pageNumber, String Id, String goodsName) {
        int idSize = Id.length();
        int NameSize =goodsName.length();
        if (idSize==0&&NameSize==0){
            String sql1="select count(1) from goods";
            String sql2="select * from goods";
            return goodsDao.nuionpageQuery(sql1,sql2,pageSize,pageNumber,null);
        }else if (idSize>0&&NameSize==0){
            //根据id具体查询
            Object []parameter = {Id};
            String sql1="select count(1) from goods where id = ?";
            String sql2 = "select * from goods where id = ?";
            return goodsDao.nuionpageQuery(sql1,sql2,pageSize,pageNumber,parameter);
        }else if (idSize==0&&NameSize>0){
            //根据姓名模糊查询
            Object []parameter = {"%"+goodsName+"%"};
            String sql1 = "select count(1) from goods where goodsName like ?";
            String sql2 = "select * from goods where goodsName like ?";
            return goodsDao.nuionpageQuery(sql1,sql2,pageSize,pageNumber,parameter);
        }else if (idSize>0&&NameSize>0){
            //根据 姓名 id  级联查询
            Object []parameter = {Id,"%"+goodsName+"%"};
            String sql1 = "select count(1) from goods where id = ? and goodsName like ?";
            String sql2 = "select * from goods where id = ? and goodsName like ?";
            return goodsDao.nuionpageQuery(sql1,sql2,pageSize,pageNumber,parameter);
        }
        return null;
    }
}
