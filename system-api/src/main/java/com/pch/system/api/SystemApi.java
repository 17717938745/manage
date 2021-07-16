package com.pch.system.api;

import com.pch.common.api.StorableApi;
import com.pch.system.api.entity.Menu;
import com.pch.system.api.entity.Role;
import com.pch.system.api.entity.User;
import com.pch.system.api.model.AuthToken;
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
public interface SystemApi extends StorableApi {

    /**
     * user api
     *
     * @return userApi
     */
    UserApi userApi();

    /**
     * role api
     *
     * @return roleApi
     */
    RoleApi roleApi();

    /**
     * menu api
     *
     * @return menuApi
     */
    MenuApi menuApi();

    /**
     * decrypt
     * @param deviceId device id
     * @param bytes byte array
     * @return decrypt
     */
    byte[] decrypt(String deviceId, byte[]bytes);

    /**
     * 查询用户
     *
     * @param signIn 登陆凭证
     * @return auth token
     */
    AuthToken signIn(SignIn signIn);

    /**
     * 登陆出
     *
     * @param signOut 登出
     * @return true or false
     */
    boolean signOut(SignOut signOut);

    /**
     * 设备是否登陆
     *
     * @param deviceId 设备标志
     * @return true or false
     */
    boolean deviceSignIn(String deviceId);

    /**
     * 登陆时候的必要入参
     *
     * @param deviceId 设备标志
     * @return a code
     */
    String requestPassCode(String deviceId);
}