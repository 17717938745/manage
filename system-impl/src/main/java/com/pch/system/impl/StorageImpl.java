package com.pch.system.impl;

import com.pch.common.api.cons.CommonConst;
import com.pch.system.api.StorageApi;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @author pch 651158394@qq.com
 * @version 2021/7/13 下午2:23
 */
@Slf4j
public class StorageImpl implements StorageApi {


    private String storageDir;

    public StorageImpl(String storageDir) {
        this.storageDir = storageDir;
    }

    @Override
    public void storage(String key, String content) {
        try {
            writeFile(key, content);
        } catch (IOException e) {
            log.error("write file error...", e);
        }
    }

    @Override
    public String load(String key) {
        try {
            return readFile(key);
        } catch (IOException e) {
            log.error("read file error", e);
            return null;
        }
    }

    /**
     * 写文件到当前路径
     *
     * @param fileName 文件名
     * @param content  内容
     */
    public void writeFile(String fileName, String content) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(storageDir + fileName), StandardCharsets.UTF_8))) {
            bw.write(content);
        }
    }

    /**
     * 读取文件内容
     *
     * @param fileName 文件名
     * @return 字符串
     */
    public String readFile(String fileName) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(storageDir + fileName), StandardCharsets.UTF_8))) {
            StringBuilder sb = new StringBuilder();
            String temp;
            while (null != (temp = br.readLine())) {
                if (sb.length() > 0) {
                    sb.append(CommonConst.CHANGE_LINE);
                }
                sb.append(temp);
            }
            return sb.toString();
        }
    }
}
