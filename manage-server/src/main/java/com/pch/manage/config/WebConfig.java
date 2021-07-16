package com.pch.manage.config;

import com.pch.common.api.StorableApi;
import com.pch.manage.filter.CipherFilter;
import com.pch.manage.interceptor.LoggerInterceptor;
import com.pch.manage.interceptor.StaticHtmlInterceptor;
import com.pch.manage.service.tools.BusinessService;
import com.pch.system.api.StorageApi;
import com.pch.system.api.SystemApi;
import com.pch.system.impl.StorageImpl;
import com.pch.system.impl.SystemImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.PostConstruct;
import javax.servlet.Filter;
import java.io.File;
import java.util.Arrays;
import java.util.List;

/**
 * @author pch 651158394@qq.com
 * @version 2021/6/17 上午9:16
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    private String uploadPath;

    @Value("${com.pch.resources.upload-path:./}")
    public void setUploadPath(String uploadPath) {
        this.uploadPath = uploadPath;
    }

    private static final String FILE_DIR_STORAGE = "storage";

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedHeaders("*")
                .allowedOrigins("*")
                .allowCredentials(true)
                .allowedMethods("*")
                .maxAge(60L * 60L);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new StaticHtmlInterceptor()).addPathPatterns("/**");
        registry.addInterceptor(new LoggerInterceptor()).addPathPatterns("/**");
    }


    @Bean
    @Order(Ordered.HIGHEST_PRECEDENCE)
    public FilterRegistrationBean<Filter> securityFilterBean() {
        FilterRegistrationBean<Filter> filterFilterRegistrationBean = new FilterRegistrationBean<>();
        filterFilterRegistrationBean.setFilter(new CipherFilter(systemApi()));
        filterFilterRegistrationBean.addUrlPatterns("/*");
        filterFilterRegistrationBean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        filterFilterRegistrationBean.setEnabled(true);
        return filterFilterRegistrationBean;
    }

    @Bean
    public StorageApi storageApi() {
        return new StorageImpl(uploadPath + FILE_DIR_STORAGE + File.separator);
    }

    @Bean
    public SystemApi systemApi() {
        return new SystemImpl(storageApi());
    }

    @Bean
    public BusinessService businessService() {
        return new BusinessService(storageApi());
    }

    @PostConstruct
    public void init() {
        final List<StorableApi> storableApiList = Arrays.asList(systemApi(), businessService());
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            for (StorableApi storableApi : storableApiList) {
                storableApi.storage();
            }
        }));
    }

    private static String getValue(Environment environment, String key) {
        String value = System.getProperty(key);
        if (null == value) {
            value = environment.getProperty(key);
        }
        return value;
    }
}

