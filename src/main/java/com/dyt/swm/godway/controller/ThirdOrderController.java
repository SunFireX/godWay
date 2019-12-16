package com.dyt.swm.godway.controller;

import com.dyt.swm.godway.common.BaseRetBean;
import com.dyt.swm.godway.entity.ThirdOrderMsg;
import com.dyt.swm.godway.service.ThirdOrderMsgService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author weiming.sun
 */
@RestController
@Slf4j
@RefreshScope
@Api(value = "第三方订单", description = "第三方订单", tags = {"ThirdOrderController"})
public class ThirdOrderController {

    @Autowired
    ThirdOrderMsgService thirdOrderMsgService;


    @GetMapping("add/log")
    public BaseRetBean<Integer> searchandrefresh() {
        ThirdOrderMsg msg = new ThirdOrderMsg();

        thirdOrderMsgService.addLog();

        return new BaseRetBean<>(1, "成功添加医生的关联的任务", 0, null);
    }






}