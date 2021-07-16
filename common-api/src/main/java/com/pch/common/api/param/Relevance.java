package com.pch.common.api.param;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author pch 651158394@qq.com
 * @version 2021/6/23 下午9:46
 */
@Data
public class Relevance<T extends Serializable, R extends Serializable> implements Serializable {

    private T current;
    private List<R> targetList;
}
