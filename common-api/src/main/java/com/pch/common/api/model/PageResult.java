package com.pch.common.api.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author pch 651158394@qq.com
 * @version 2021/6/23 下午9:55
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class PageResult<T> extends Result {

    private long total;
    private List<T> items;

    public PageResult(long total, List<T> items) {
        this.total = total;
        this.items = items;
    }
}
