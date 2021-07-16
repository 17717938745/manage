package com.pch.system.api.param;

import lombok.Data;

import java.io.Serializable;

/**
 * @author pch 651158394@qq.com
 * @version 2021/7/1 下午5:35
 */
@Data
public class SignIn implements Serializable {

    private String username;
    private String password;
    private String deviceId;
}
