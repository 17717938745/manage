package com.pch.manage.filter;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.pch.common.api.bean.CustomerException;
import com.pch.common.api.bean.ErrorCode;
import com.pch.common.api.model.Result;
import com.pch.system.api.SystemApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;

/**
 * @author pch 651158394@qq.com
 * @version 2018/9/28 上午11:23
 */
@ControllerAdvice
@Slf4j
public class GlobalHandler {

    /**
     * 返回统一的异常
     *
     * @param request  略
     * @param response 略
     * @param e        略
     * @return 自定义类
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result exceptionHandler(HttpServletRequest request, HttpServletResponse response, Exception e) {
        log.error("not know exception", e);
        return new Result(ErrorCode.SERVER_ERROR);
    }

    @ExceptionHandler(CustomerException.class)
    public Result customerExceptionHandler(HttpServletRequest request, HttpServletResponse response, CustomerException e) {
        log.error("customer exception", e);
        if (e.getCode() == ErrorCode.DECRYPT_FAIL) {
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
        }
        return new Result(e.getCode());
    }
}
