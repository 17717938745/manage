package com.pch.manage.filter;

import cn.hutool.core.util.StrUtil;
import com.pch.common.api.bean.CustomerException;
import com.pch.common.api.bean.ErrorCode;
import com.pch.common.api.cons.CommonConst;
import com.pch.system.api.SystemApi;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

import javax.servlet.*;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;

/**
 * @author pch 651158394@qq.com
 * @version 2021/7/14 上午12:48
 */
@Slf4j
@AllArgsConstructor
public class CipherFilter extends HttpFilter {

    final private SystemApi systemApi;

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request;
        HttpServletResponse response;
        if (req instanceof HttpServletRequest &&
                res instanceof HttpServletResponse &&
                !CommonConst.REQUEST_METHOD_OPTIONS.equalsIgnoreCase((request = (HttpServletRequest) req).getMethod())
        ) {
            response = (HttpServletResponse) res;
            final String deviceId = request.getHeader("Device-Id"),
                    uri = request.getRequestURI().substring(request.getContextPath().length());
            log.info("deviceId: {}, uri: {}", deviceId, uri);
            boolean needDecrypt = uri.startsWith("/auth/"),
                    needAuth = needDecrypt || uri.startsWith("/upload/");
            if (needAuth && !systemApi.deviceSignIn(deviceId)) {
                crossOrigin(request, response);
                response.setStatus(HttpStatus.UNAUTHORIZED.value());
            } else if (needDecrypt) {
                final SecurityRequestWrapper securityRequestWrapper = new SecurityRequestWrapper(request, deviceId);
                final HttpServletResponse servletResponseWrapper = (HttpServletResponse) res;
                chain.doFilter(securityRequestWrapper, servletResponseWrapper);
            } else {
                chain.doFilter(req, res);
            }
        } else {
            chain.doFilter(req, res);
        }
    }

    public static void crossOrigin(HttpServletRequest request, HttpServletResponse response) {
        response.setCharacterEncoding("utf-8");
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Allow-Methods", "*");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type, x-requested-with, X-Custom-Header, Request-Ajax, Authorization, Security-Token");
        response.setHeader("Access-Control-Allow-Headers", "*");
        String origin = request.getHeader("Origin");
        if (null != origin && origin.trim().length() > 0) {
            response.setHeader("Access-Control-Allow-Origin", origin);
        } else {
            response.setHeader("Access-Control-Allow-Origin", "*");
        }
    }

    public class SecurityRequestWrapper extends HttpServletRequestWrapper implements Closeable {

        protected String deviceId;
        protected SecurityServletInputStream securityServletInputStream;

        /**
         * Constructs a request object wrapping the given request.
         *
         * @param request the {@link HttpServletRequest} to be wrapped.
         * @throws IllegalArgumentException if the request is null
         */
        public SecurityRequestWrapper(HttpServletRequest request, String deviceId) {
            super(request);
            this.deviceId = deviceId;
        }

        @Override
        public ServletInputStream getInputStream() throws IOException {
            log.info("getInputStream...");
            securityServletInputStream = new SecurityServletInputStream(deviceId, super.getInputStream());
            return securityServletInputStream;
        }

        @Override
        public void close() throws IOException {
            log.info("SecurityRequestWrapper.close...");
            if (null != securityServletInputStream) {
                securityServletInputStream.close();
            }
        }
    }

    public class SecurityServletInputStream extends ServletInputStream {

        protected String deviceId;
        private ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        private ByteArrayInputStream byteArrayInputStream;
        final ServletInputStream servletInputStream;

        public SecurityServletInputStream(String deviceId, ServletInputStream servletInputStream) throws RuntimeException {
            this.deviceId = deviceId;
            this.servletInputStream = servletInputStream;
            byte[] bytes = new byte[1024];
            int len;
            try {
                while (-1 != (len = servletInputStream.read(bytes))) {
                    byteArrayOutputStream.write(bytes, 0, len);
                }
                if (byteArrayOutputStream.size() > 0) {
                    byte[] decrypt = CipherFilter.this.systemApi.decrypt(deviceId, byteArrayOutputStream.toByteArray());
                    log.info("decrypt: {}", StrUtil.utf8Str(decrypt));
                    if (null == decrypt) {
                        throw new CustomerException(ErrorCode.DECRYPT_FAIL);
                    }
                    byteArrayInputStream = new ByteArrayInputStream(decrypt);
                }
            } catch (IOException e) {
                log.error("", e);
            }
        }

        @Override
        public boolean isFinished() {
            log.info("isFinished...");
            return servletInputStream.isFinished();
        }

        @Override
        public boolean isReady() {
            log.info("isReady...");
            return servletInputStream.isReady();
        }

        @Override
        public void setReadListener(ReadListener readListener) {
            log.info("readListener: {}", readListener);
            servletInputStream.setReadListener(readListener);
        }

        @Override
        public synchronized void reset() throws IOException {
            log.info("reset...");
            byteArrayInputStream.reset();
        }

        @Override
        public int read() {
            return byteArrayInputStream.read();
        }

        @Override
        public void close() throws IOException {
            log.info("close...");
            super.close();
            if (null != byteArrayInputStream) {
                byteArrayInputStream.close();
            }
            if (null != servletInputStream) {
                servletInputStream.close();
            }
            if (null != byteArrayOutputStream) {
                byteArrayOutputStream.close();
            }
        }
    }
}