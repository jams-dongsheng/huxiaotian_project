package com.huxiaotian.user.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.huxiaotian.mapper.HxtRoomMapper;
import com.huxiaotian.mapper.HxtUserMapper;

import com.huxiaotian.pojo.HxtRoom;
import com.huxiaotian.pojo.HxtUser;
import com.huxiaotian.pojo.HxtUserExample;
import com.huxiaotian.pojo.entity.Result;
import com.huxiaotian.pojo.group.Room;
import com.huxiaotian.service.UserService;
import com.huxiaotian.util.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import sun.dc.pr.PRError;


import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private HxtUserMapper hxtUserMapper;

    @Autowired
    private IdWorker idWorker;

    @Autowired
    private HxtRoomMapper hxtRoomMapper;

    /**
     * 通过住户姓名或房间号查询用户信息
     * @return
     */
    @Override
    public Room findByNameOrId(String search) {
        Room room = new Room();
        //根据住户姓名查找
        HxtUserExample example = new HxtUserExample();
        HxtUserExample.Criteria criteria1 = example.createCriteria();
        criteria1.andNameEqualTo(search);
        List<HxtUser> hxtUsers = hxtUserMapper.selectByExample(example);
        if(hxtUsers != null && hxtUsers.size() >0){//找到存入最新的订单信息
            room.setHxtUser(hxtUsers.get(0));
            String userRoomId = hxtUsers.get(0).getUserRoomId();
            HxtRoom hxtRoom = hxtRoomMapper.selectByPrimaryKey(userRoomId);
            room.setHxtRoom(hxtRoom);
            return room;
        }
        //如果未查到，再根据房间号查询
        HxtRoom hxtRoom = hxtRoomMapper.selectByPrimaryKey(search);
        if(hxtRoom != null){
            room.setHxtRoom(hxtRoom);
            //判断是否有人入住
            if(hxtRoom.getRoomStatus().equals("2")){
                //如果入住,查询订单表
                HxtUserExample example1 = new HxtUserExample();
                HxtUserExample.Criteria criteria = example1.createCriteria();
                criteria.andUserRoomIdEqualTo(hxtRoom.getRoomId());
                //按时间排序未做
                List<HxtUser> hxtUsers1 = hxtUserMapper.selectByExample(example1);
                room.setHxtUser(hxtUsers1.get(0));
            }
            return room;
        }
        return null;
    }

    /**
     * 入住
     * @param user
     * @return
     */
    @Override
    public void add(HxtUser user) {
        HxtUser hxtUser = new HxtUser();
        hxtUser.setUserId(String.valueOf(idWorker.nextId()));
        hxtUser.setName(user.getName());//姓名
        //hxtUser.setGender(user.getGender());//性别
        hxtUser.setIdCardNo(user.getIdCardNo());//身份证
        hxtUser.setCheckIn(new Date());//入住日期
        hxtUser.setCheckOut(user.getCheckOut());//退房日期
        hxtUser.setUserRoomId(user.getUserRoomId());//房间号
        hxtUserMapper.insert(hxtUser);
    }
}
