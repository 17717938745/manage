package com.pch.manage.interceptor;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletOutputStream;
import javax.servlet.WriteListener;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @author pch 651158394@qq.com
 * @version 2020/8/4 2:25 下午
 */
@Slf4j
public class SecurityServletOutputStream extends ServletOutputStream {

    private ServletOutputStream servletOutputStream;
    private ByteArrayOutputStream byteArrayOutputStream;

    public SecurityServletOutputStream(ServletOutputStream servletOutputStream) {
        this.servletOutputStream = servletOutputStream;
        byteArrayOutputStream = new ByteArrayOutputStream();
    }

    @Override
    public void flush() throws IOException {
        servletOutputStream.flush();
    }

    @Override
    public boolean isReady() {
        return servletOutputStream.isReady();
    }

    @Override
    public void setWriteListener(WriteListener writeListener) {
        servletOutputStream.setWriteListener(writeListener);
    }

    @Override
    public void write(int i) {
        byteArrayOutputStream.write(i);
    }

    @Override
    public void close() throws IOException {
        super.close();
        if (null != byteArrayOutputStream) {
            byteArrayOutputStream.close();
        }
    }

    public byte[] toByteArray() {
        if (null != byteArrayOutputStream) {
            return byteArrayOutputStream.toByteArray();
        }
        return new byte[0];
    }

    public void reset(String result) throws IOException {
        if (null != result) {
            byteArrayOutputStream.reset();
            byteArrayOutputStream.write(result.getBytes());
        }
    }

    public void write(String result) throws IOException {
        if (null != result) {
            servletOutputStream.write(result.getBytes());
        }
    }

    @Override
    public void write(byte[] bytes) throws IOException {
        if (null != bytes) {
            servletOutputStream.write(bytes);
        }
    }
}
