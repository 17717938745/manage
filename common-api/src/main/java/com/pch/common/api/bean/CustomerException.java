package com.pch.common.api.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author pch 651158394@qq.com
 * @version 2021/7/1 上午11:36
 */
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class CustomerException extends RuntimeException {

    private int code;
}
