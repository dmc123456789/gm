package service.impl;

import dao.impl.GoodsDaoImpl;
import dao.impl.anmouncementDaoImpl;
import pojo.Announcement;
import pojo.Page;
import service.AnnouncementServiceDao;

/**
 * ClassName service.impl
 *
 * @Author dmc
 * @Date 2019/1/2 10:14
 * @Version V1.0
 **/
public class AnnouncementServiceDaoImpl implements AnnouncementServiceDao {
    private static AnnouncementServiceDaoImpl ourInstance = new AnnouncementServiceDaoImpl();
    public static AnnouncementServiceDaoImpl getInstance() {
        return ourInstance;
    }
    private AnnouncementServiceDaoImpl() {
    }
    private anmouncementDaoImpl goodsDao= anmouncementDaoImpl.getInstance();
    //分页查询
    public Page<Announcement> goodspageQuery(int pageSize, int pageNumber) {
        return goodsDao.pageQuery(pageSize,pageNumber);
    }
 //删除
    public Boolean delgoods(int id) {

        return goodsDao.goodsdel(id);
    }
  //添加
    public int goodsAdd(Announcement a) {
        String sql="insert set announcement (aTitle,aText,aDate) values (?,?,?)";
        return goodsDao.goodsadd(sql,a);
    }
}
