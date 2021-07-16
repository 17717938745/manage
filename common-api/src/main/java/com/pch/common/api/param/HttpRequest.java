package com.pch.common.api.param;

import lombok.Data;

import java.io.Serializable;

/**
 * @author pch 651158394@qq.com
 * @version 2021/7/1 下午5:59
 */
@Data
public class HttpRequest implements Serializable {

    private String traceId;
}
