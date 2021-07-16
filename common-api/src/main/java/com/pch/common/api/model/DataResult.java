package com.pch.common.api.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author pch 651158394@qq.com
 * @version 2021/6/23 下午9:55
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class DataResult<T> extends Result {

    private T data;

    public DataResult(int errorCode, T data) {
        if (null == data) {
            super.setCode(errorCode);
        } else {
            this.data = data;
        }
    }
}
