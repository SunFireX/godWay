package com.dyt.swm.godway.controller;

import com.dyt.swm.godway.common.BaseRetBean;
import com.dyt.swm.godway.service.ThirdOrderMsgService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(value = "批处理管理API", description = "批量管理第三方医生等数据", tags = {"BatchController"})
public class BatchController {

    @Autowired
    ThirdOrderMsgService thirdOrderMsgService;


    @GetMapping("add/log")
    @ApiOperation(value = "关联第三方supplier平台医生和己方所有医院的医生")
    public BaseRetBean<Integer> searchandrefresh() {
        

        return new BaseRetBean<>(1, "成功添加医生的关联的任务", 0, null);
    }






}