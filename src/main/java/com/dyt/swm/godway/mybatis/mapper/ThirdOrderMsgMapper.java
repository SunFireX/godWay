package com.dyt.swm.godway.mybatis.mapper;

import com.dyt.swm.godway.entity.ThirdOrderMsg;
import com.dyt.swm.godway.entity.ThirdOrderMsgExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ThirdOrderMsgMapper {
    long countByExample(ThirdOrderMsgExample example);

    int deleteByExample(ThirdOrderMsgExample example);

    int deleteByPrimaryKey(String id);

    int insert(ThirdOrderMsg record);

    int insertSelective(ThirdOrderMsg record);

    List<ThirdOrderMsg> selectByExample(ThirdOrderMsgExample example);

    ThirdOrderMsg selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ThirdOrderMsg record, @Param("example") ThirdOrderMsgExample example);

    int updateByExample(@Param("record") ThirdOrderMsg record, @Param("example") ThirdOrderMsgExample example);

    int updateByPrimaryKeySelective(ThirdOrderMsg record);

    int updateByPrimaryKey(ThirdOrderMsg record);
}