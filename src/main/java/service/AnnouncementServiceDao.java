package service;

import pojo.Announcement;

import pojo.Page;

public interface AnnouncementServiceDao {
    Page<Announcement> goodspageQuery(int pageSize, int pageNumber);
    //修改
    //删除
    Boolean delgoods(int id);
    //添加
    int goodsAdd(Announcement a);
}
