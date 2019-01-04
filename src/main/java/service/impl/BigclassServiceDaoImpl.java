package service.impl;

import dao.impl.BigClassDaoImpl;
import pojo.Bigclass;
import pojo.Page;
import service.BigClassServiceDao;

import java.util.List;

/**
 * ClassName service.impl
 *
 * @Author dmc
 * @Date 2018/12/29 15:01
 * @Version V1.0
 **/
public class BigclassServiceDaoImpl implements BigClassServiceDao {
    /**
     * 单例
     */
    private static BigclassServiceDaoImpl ourInstance = new BigclassServiceDaoImpl();
    public static BigclassServiceDaoImpl getInstance() {
        return ourInstance;
    }
    private BigclassServiceDaoImpl() {
    }
    private BigClassDaoImpl BigDao=BigClassDaoImpl.getInstance();

    /**
     * 查询所有大分类信息
     */
    public Page<Bigclass> BigPageQueryAll(int pageSize, int pageNumber) {

        return BigDao.pageQuery(pageSize,pageNumber);
    }

    public int cusUpdate(Bigclass big) {
     String sql="update bigclass set bigName=?,bigText=? where id=？";
     Object []parameter={big.getId(),big.getBigName(),big.getBigText()};
        return BigDao.update(sql,parameter);
    }

    //修改
    public Bigclass cusQueryByid(int id) {
        String sql="select * from bigclass where id=?";
        Object [] parameter={id};
        List<Bigclass> cuslist=BigDao.query(sql,parameter);
        if (cuslist!=null&&cuslist.size()>0) {
            return cuslist.get(0);
        }
        return null;
    }

    //添加
    public int BigclassAdd(Bigclass bc) {
     String sql="insert into bigclass (bigName,bigtext) values(?,?)";
        return BigDao.Bigclassadd(sql,bc);
    }
  //删除
    public Boolean delbigclass(int id) {
        return BigDao.delBigclass(id);
    }


}
