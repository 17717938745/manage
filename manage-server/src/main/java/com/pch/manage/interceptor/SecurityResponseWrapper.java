package com.pch.manage.interceptor;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author pch 651158394@qq.com
 * @version 2020/8/4 11:11 上午
 */
public class SecurityResponseWrapper extends HttpServletResponseWrapper {

    private SecurityServletOutputStream securityServletOutputStream;

    /**
     * Constructs a response adaptor wrapping the given response.
     *
     * @param response the {@link HttpServletResponse} to be wrapped.
     * @throws IllegalArgumentException if the response is null
     */
    public SecurityResponseWrapper(HttpServletResponse response) {
        super(response);
    }

    @Override
    public ServletOutputStream getOutputStream() throws IOException {
        return newInstance();
    }

    @Override
    public void flushBuffer() throws IOException {
        if (null != securityServletOutputStream) {
            securityServletOutputStream.flush();
        }
    }

    @Override
    public PrintWriter getWriter() throws IOException {
        return super.getWriter();
    }

    @Override
    public String getCharacterEncoding() {
        String characterEncoding = super.getCharacterEncoding();
        if (null == characterEncoding || characterEncoding.trim().length() == 0) {
            return "utf-8";
        } else {
            return characterEncoding;
        }
    }

    public synchronized SecurityServletOutputStream newInstance() throws IOException {
        if (null == securityServletOutputStream) {
            securityServletOutputStream = new SecurityServletOutputStream(super.getOutputStream());
        }
        return securityServletOutputStream;
    }
}
