package service.impl;

import dao.impl.orderseDaoImpl;
import pojo.Extorderse;
import pojo.Page;
import service.orderseServiceDao;

import java.util.List;

/**
 * ClassName service.impl
 *
 * @Author dmc
 * @Date 2019/1/4 9:55
 * @Version V1.0
 **/
public class orderseServiceDaoImpl implements orderseServiceDao {
    private static orderseServiceDaoImpl ourInstance = new orderseServiceDaoImpl();
    public static orderseServiceDaoImpl getInstance() {
        return ourInstance;
    }
    private orderseServiceDaoImpl() {
    }
    private orderseDaoImpl orDao= orderseDaoImpl.getInstance();

    /**
     *分页查询订单
     * @return
     */
    public Page<Extorderse> goodspageQuery(int pageSize, int pageNumber) {

        return orDao.pageQuery(pageSize,pageNumber);
    }
}
