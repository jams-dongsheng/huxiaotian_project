package com.huxiaotian.room.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.huxiaotian.mapper.HxtRoomMapper;
import com.huxiaotian.pojo.HxtRoom;
import com.huxiaotian.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private HxtRoomMapper hxtRoomMapper;

    /**
     * 入住
     * @param roomId
     */
    @Override
    public void updateStatusByIn(String roomId) {
        HxtRoom hxtRoom = hxtRoomMapper.selectByPrimaryKey(roomId);
        hxtRoom.setRoomStatus("2");
        hxtRoomMapper.updateByPrimaryKey(hxtRoom);
    }

    /**
     * 退房
     * @param roomId
     */
    @Override
    public void updateStatusByOut(String roomId) {
        HxtRoom hxtRoom = hxtRoomMapper.selectByPrimaryKey(roomId);
        hxtRoom.setRoomStatus("1");
        hxtRoomMapper.updateByPrimaryKey(hxtRoom);
    }
}
