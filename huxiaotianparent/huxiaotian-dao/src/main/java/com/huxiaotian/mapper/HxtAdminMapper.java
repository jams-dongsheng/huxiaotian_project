package com.huxiaotian.mapper;

import com.huxiaotian.pojo.HxtAdmin;
import com.huxiaotian.pojo.HxtAdminExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HxtAdminMapper {
    long countByExample(HxtAdminExample example);

    int deleteByExample(HxtAdminExample example);

    int deleteByPrimaryKey(String username);

    int insert(HxtAdmin record);

    int insertSelective(HxtAdmin record);

    List<HxtAdmin> selectByExample(HxtAdminExample example);

    HxtAdmin selectByPrimaryKey(String username);

    int updateByExampleSelective(@Param("record") HxtAdmin record, @Param("example") HxtAdminExample example);

    int updateByExample(@Param("record") HxtAdmin record, @Param("example") HxtAdminExample example);

    int updateByPrimaryKeySelective(HxtAdmin record);

    int updateByPrimaryKey(HxtAdmin record);
}