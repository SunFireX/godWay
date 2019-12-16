package com.dyt.swm.godway.service.impl;

import com.dyt.swm.godway.common.SnowflakeIdWorker;
import com.dyt.swm.godway.entity.ThirdOrderMsg;
import com.dyt.swm.godway.mybatis.mapper.ThirdOrderMsgMapper;
import com.dyt.swm.godway.service.ThirdOrderMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author weiming.sun
 */
@Service
public class ThirdOrderMsgServiceImpl implements ThirdOrderMsgService {

    @Autowired
    ThirdOrderMsgMapper msgMapper;

    @Autowired
    SnowflakeIdWorker idWorker;

    @Override
    public void addLog() {
        ThirdOrderMsg msg = new ThirdOrderMsg();
        msg.setId(idWorker.nextId());
        msg.setAppid("11111");
        msg.setCreateTime(new Date());
        msgMapper.insert(msg);
    }



}
