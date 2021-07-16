package com.pch.system.api.bean;

import com.pch.system.api.entity.User;
import lombok.Data;

import java.io.Serializable;
import java.security.KeyPair;

/**
 * @author pch 651158394@qq.com
 * @version 2021/7/1 下午5:39
 */
@Data
public class DeviceInfo implements Serializable {

    private String deviceId;
    private Long createMillis;
    private Long updateMillis;

    private User user;
    private String passCode;
    private byte[] clientPrivateKey;
    private byte[] clientPublicKey;
    private byte[] serverPrivateKey;
    private byte[] serverPublicKey;
}
