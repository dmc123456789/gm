package service.impl;

import dao.impl.sellerDaoImpl;
import pojo.Page;
import pojo.Seller;
import service.sellerServiceDao;

/**
 * ClassName service.impl
 *
 * @Author dmc
 * @Date 2019/1/2 11:17
 * @Version V1.0
 **/
public class SellerServiceDaoImpl implements sellerServiceDao {
    private static SellerServiceDaoImpl ourInstance = new SellerServiceDaoImpl();
    public static SellerServiceDaoImpl getInstance() {
        return ourInstance;
    }
    private SellerServiceDaoImpl() {
    }
    private sellerDaoImpl goodsDao= sellerDaoImpl.getInstance();

    //分页查询
    public Page<Seller> goodspageQuery(int pageSize, int pageNumber) {
        return goodsDao.pageQuery(pageSize,pageNumber);
    }
  //删除
    public Boolean delgoods(int id) {
        return goodsDao.goodsdel(id);
    }
   //添加
    public int goodsAdd(Seller Seller) {
        String sql="insert into seller (sellerName,sellerUser,sellerPassword,sellerPassword,sellerSex," +
                "sellerBirthday,sellerIdCard,sellerTel,sellerAddress) values (?,?,?,?,?,?,?)";
        return goodsDao.goodsadd(sql,Seller);
    }
}
