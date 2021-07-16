package com.pch.manage.interceptor;

import cn.hutool.core.util.StrUtil;
import com.pch.common.api.cons.CommonConst;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.web.servlet.AsyncHandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author pch 651158394@qq.com
 * @version 2021/6/17 上午9:15
 */
@Slf4j
public class LoggerInterceptor implements AsyncHandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        MDC.put("traceId", StrUtil.emptyToDefault(request.getHeader("Trace-Id"), Thread.currentThread().getName()));
        return true;
    }
}
