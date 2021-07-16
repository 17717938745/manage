package com.pch.manage.config;

import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

/**
 * @author pch 651158394@qq.com
 * @version 2020/11/29 11:32 上午
 */
@Configuration
public class ErrorPageConfig implements ErrorPageRegistrar {

    @Override
    public void registerErrorPages(ErrorPageRegistry registry) {
        ErrorPage[] errorPageList = new ErrorPage[1];
        ErrorPage errorPage = new ErrorPage(HttpStatus.NOT_FOUND, "/manage/index.html");
        errorPageList[0] = errorPage;
        registry.addErrorPages(errorPageList);
    }
}
