package com.pch.common.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author pch 651158394@qq.com
 * @version 2021/6/23 下午9:55
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ItemResult<T> extends Result {

    private List<T> items;

    public ItemResult(int errorCode, List<T> items) {
        if(null== items) {
            super.setCode(errorCode);
        } else {
            this.items = items;
        }
    }
}
