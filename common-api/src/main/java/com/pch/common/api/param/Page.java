package com.pch.common.api.param;

import lombok.Data;

import java.io.Serializable;

/**
 * @author pch 651158394@qq.com
 * @version 2021/6/23 下午9:46
 */
@Data
public class Page implements Serializable {

    private int page;
    private int limit;
}
