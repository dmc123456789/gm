package service;

import pojo.Extorderse;
import pojo.Page;

import java.util.List;

public interface orderseServiceDao {
    //查询订单
    Page<Extorderse> goodspageQuery(int pageSize, int pageNumber);
    //修改订单
}
