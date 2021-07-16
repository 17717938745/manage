package com.pch.common.api;

import java.io.Serializable;
import java.util.List;

/**
 * @author pch 651158394@qq.com
 * @version 2021/7/13 下午5:26
 */
public interface CrudApi<T extends Serializable> {

    /**
     * list
     *
     * @return list
     */
    List<T> list();

    /**
     * save
     *
     * @param t
     * @return t
     */
    T save(T t);

    /**
     * update
     *
     * @param t
     * @return t
     */
    T update(T t);

    /**
     * delete
     *
     * @param list list
     * @return list
     */
    List<T> delete(List<T> list);
}
