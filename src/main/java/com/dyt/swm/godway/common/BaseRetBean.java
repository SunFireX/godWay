package com.dyt.swm.godway.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * 出参基础类
 * 
 * @author max
 * 
 */
@ApiModel("BaseRetBean(出参基础类)")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BaseRetBean<T> {

    @ApiModelProperty("消息代码, 默认为true")
    private int    code;
    @ApiModelProperty("错误信息")
    private String message;
    @ApiModelProperty("错误编码")
    private Object errors;
    @ApiModelProperty("业务参数对象")
    private T      results;

}
