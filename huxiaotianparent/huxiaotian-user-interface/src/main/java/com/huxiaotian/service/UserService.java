package com.huxiaotian.service;


import com.huxiaotian.pojo.HxtUser;
import com.huxiaotian.pojo.entity.Result;
import com.huxiaotian.pojo.group.Room;

public interface UserService {

    /**
     * 通过住户姓名或者房间号查询房间
     * @return
     */
    public Room findByNameOrId(String search);

    /**
     * 入住
     * @param user
     * @return
     */
    public void add(HxtUser user);
}
