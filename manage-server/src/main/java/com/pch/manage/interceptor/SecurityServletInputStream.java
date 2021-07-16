package com.pch.manage.interceptor;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @author pch 651158394@qq.com
 * @version 2020/8/4 2:25 下午
 */
@Slf4j
public class SecurityServletInputStream extends ServletInputStream {

    private ServletInputStream servletInputStream;
    private ByteArrayInputStream byteArrayInputStream;

    public SecurityServletInputStream(ServletInputStream servletInputStream) {
        this.servletInputStream = servletInputStream;
        byte[] bytes = new byte[1024];
        int len;
        try (final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {
            while (-1 != (len = servletInputStream.read(bytes))) {
                byteArrayOutputStream.write(bytes, 0, len);
            }
            byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        } catch (IOException e) {
            log.error("", e);
        }
    }


    @Override
    public int readLine(byte[] b, int off, int len) throws IOException {
        return servletInputStream.read(b, off, len);
    }

    @Override
    public boolean isFinished() {
        return servletInputStream.isFinished();
    }

    @Override
    public boolean isReady() {
        return servletInputStream.isReady();
    }

    @Override
    public void setReadListener(ReadListener readListener) {
        servletInputStream.setReadListener(readListener);
    }

    @Override
    public int read() throws IOException {
        return byteArrayInputStream.read();
    }
}
