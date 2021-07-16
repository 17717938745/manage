package com.pch.common.api;

import com.pch.common.api.param.Relevance;

import java.io.Serializable;
import java.util.List;

/**
 * @author pch 651158394@qq.com
 * @version 2021/7/13 下午5:26
 */
public interface RelevanceApi<T extends Serializable, R extends Serializable> extends CrudApi<T> {

    /**
     * relate list
     *
     * @param t t
     * @return r list
     */
    List<R> relateList(T t);

    /**
     * relate refresh
     *
     * @param tr tr
     * @return r list
     */
    List<R> relateRefresh(Relevance<T, R> tr);
}
