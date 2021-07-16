package com.pch.system.api;

import com.pch.system.api.entity.Menu;
import com.pch.system.api.entity.Role;
import com.pch.system.api.entity.User;
import com.pch.system.api.param.RelateRole;
import com.pch.system.api.param.RelateUser;
import com.pch.system.api.param.SignIn;
import com.pch.system.api.param.SignOut;

import java.io.Serializable;
import java.util.List;

/**
 * @author pch 651158394@qq.com
 * @version 2021/6/17 上午9:45
 */
public interface StorageApi extends Serializable {

    /**
     * storage
     * @param key key
     * @param content content
     */
    void storage(String key, String content);

    /**
     * load
     * @param key key
     * @return content
     */
    String load(String key);
}