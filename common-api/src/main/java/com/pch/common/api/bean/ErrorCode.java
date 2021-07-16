package com.pch.common.api.bean;

/**
 * @author pch 651158394@qq.com
 * @version 2021/7/1 上午11:36
 */
public class ErrorCode {

    public static int count = 0;
    public static final int SERVER_ERROR = ++count;

    public static final int FILE_WRITE_FAILED = ++count;
    public static final int FILE_ALREADY_EXISTS = ++count;
    public static final int FILE_CREATE_FAILED = ++count;

    public static final int SIGN_IN_FAIL = ++count;
    public static final int SIGN_OUT_FAIL = ++count;

    public static final int LOCATE_FAIL = ++count;
    public static final int LIST_FAIL = ++count;
    public static final int SAVE_FAIL = ++count;
    public static final int UPDATE_FAIL = ++count;
    public static final int DECRYPT_FAIL = ++count;
}
