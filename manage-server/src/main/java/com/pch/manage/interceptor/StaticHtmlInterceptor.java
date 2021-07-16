package com.pch.manage.interceptor;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.AsyncHandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author pch 651158394@qq.com
 * @version 2021/6/17 上午9:15
 */
@Slf4j
public class StaticHtmlInterceptor implements AsyncHandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        if (HttpStatus.NOT_FOUND.value() == response.getStatus()) {
            log.info("response status 404, uri {}, and redirect to generate/index.html", request.getRequestURI());
            response.setStatus(HttpStatus.OK.value());
        }
        return true;
    }
}
