package com.pch.common.api;

import com.pch.common.api.model.PageResult;
import com.pch.common.api.param.Page;

import java.io.Serializable;

/**
 * @author pch 651158394@qq.com
 * @version 2021/7/13 下午5:26
 */
public interface PageableApi<T extends Serializable> extends CrudApi<T> {

    /**
     * page list
     *
     * @param page page
     * @return page list
     */
    PageResult<T> page(Page page);

}
