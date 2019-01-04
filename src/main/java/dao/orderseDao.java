package dao;

import pojo.Extorderse;
import pojo.Page;

import java.util.List;

public interface orderseDao {
     //查询订单
     List<Extorderse>query(String sql);
     Page<Extorderse> pageQuery(int pageSize, int pageNumber);
     //修改订单

}
