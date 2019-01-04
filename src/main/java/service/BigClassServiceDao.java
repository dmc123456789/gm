package service;

import pojo.Bigclass;
import pojo.Page;

public interface BigClassServiceDao {
    //查询所有大分类信息
    Page<Bigclass> BigPageQueryAll(int pageSize, int pageNumber);
    //修改大分类信息
    int cusUpdate(Bigclass big);
    Bigclass cusQueryByid(int id);
    //添加大分类信息
    int BigclassAdd(Bigclass bcs);
    //删除大分类信息
    Boolean delbigclass(int id);
}
