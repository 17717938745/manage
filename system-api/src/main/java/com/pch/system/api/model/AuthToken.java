package com.pch.system.api.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author pch 651158394@qq.com
 * @version 2021/7/14 下午3:05
 */
@Data
public class AuthToken implements Serializable {

    private String publicKey;
    private String privateKey;
}
