package service.impl;

import dao.impl.SmallclassDaoImpl;
import pojo.Page;
import pojo.Smallclass;
import service.SmallclassServiceDao;

import javax.naming.Name;
import java.util.List;

/**
 * ClassName service.impl
 *
 * @Author dmc
 * @Date 2018/12/30 18:33
 * @Version V1.0
 **/
public class SmallclassServiceDaoImpl implements SmallclassServiceDao {
    private static SmallclassServiceDaoImpl ourInstance = new SmallclassServiceDaoImpl();
    public static SmallclassServiceDaoImpl getInstance() {
        return ourInstance;
    }
    private SmallclassServiceDaoImpl() {
    }
    private SmallclassDaoImpl smallDao= SmallclassDaoImpl.getInstance();


    //分页查询
    public Page<Smallclass> smallclasspageQuery(int pageSize, int pageNumber) {

        return smallDao.pageQuery(pageSize,pageNumber);
    }
    //删除
    public Boolean delSmallclass(int id) {
        return smallDao.delSmallclass(id);
    }
    //添加
    public int SmaclassAdd(Smallclass sma) {
        String sql="insert into smallclass (smallName,smallBigId,smallText) values(?,?,?)";
        return smallDao.smallclassadd(sql,sma);

    }
    //级联查询
    public Page<Smallclass> SmaPageunionQuery(int pageSize, int pageNumber, String Id, String smallName) {
        int idSize = Id.length();
        int NameSize =smallName.length();
        if (idSize==0&&NameSize==0){
        String sql1="select count(1) from smallclass";
        String sql2="select * from smallclass";
        return smallDao.nuionpageQuery(sql1,sql2,pageSize,pageNumber,null);
        }else if (idSize>0&&NameSize==0){
            //根据id具体查询
            Object []parameter = {Id};
            String sql1="select count(1) from smallclass where id = ?";
            String sql2 = "select * from smallclass where id = ?";
            return smallDao.nuionpageQuery(sql1,sql2,pageSize,pageNumber,parameter);
        }else if (idSize==0&&NameSize>0){
            //根据姓名模糊查询
            Object []parameter = {"%"+smallName+"%"};
            String sql1 = "select count(1) from smallclass where smallName like ?";
            String sql2 = "select * from smallclass where smallName like ?";
            return smallDao.nuionpageQuery(sql1,sql2,pageSize,pageNumber,parameter);
        }else if (idSize>0&&NameSize>0){
            //根据 姓名 id  级联查询
            Object []parameter = {Id,"%"+smallName+"%"};
            String sql1 = "select count(1) from smallclass where id = ? and smallName like ?";
            String sql2 = "select * from smallclass where id = ? and smallName like ?";
            return smallDao.nuionpageQuery(sql1,sql2,pageSize,pageNumber,parameter);
        }
        return null;
    }
}
