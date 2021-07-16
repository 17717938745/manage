package com.pch.common.api.model;

import com.pch.common.api.cons.CommonConst;
import lombok.Data;

import java.io.Serializable;

/**
 * @author pch 651158394@qq.com
 * @version 2021/6/23 下午9:55
 */
@Data
public class Result implements Serializable {

    protected int code;
//    private String errorMsg;
//    private String clientId;
//    private String traceId;

    public Result() {
        this.code = CommonConst.RESULT_CODE_OK;
    }

    public Result(int code) {
        this.code = code;
    }
}
