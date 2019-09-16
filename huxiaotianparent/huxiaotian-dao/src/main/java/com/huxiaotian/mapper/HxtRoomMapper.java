package com.huxiaotian.mapper;

import com.huxiaotian.pojo.HxtRoom;
import com.huxiaotian.pojo.HxtRoomExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HxtRoomMapper {
    long countByExample(HxtRoomExample example);

    int deleteByExample(HxtRoomExample example);

    int deleteByPrimaryKey(String roomId);

    int insert(HxtRoom record);

    int insertSelective(HxtRoom record);

    List<HxtRoom> selectByExample(HxtRoomExample example);

    HxtRoom selectByPrimaryKey(String roomId);

    int updateByExampleSelective(@Param("record") HxtRoom record, @Param("example") HxtRoomExample example);

    int updateByExample(@Param("record") HxtRoom record, @Param("example") HxtRoomExample example);

    int updateByPrimaryKeySelective(HxtRoom record);

    int updateByPrimaryKey(HxtRoom record);
}