package com.pch.system.api.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author pch 651158394@qq.com
 * @version 2021/7/1 下午6:04
 */
@Data
public class UserRole implements Serializable {

    private String username;
    private String code;
}