package com.pch.manage.service;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.pch.common.api.bean.ErrorCode;
import com.pch.common.api.cons.CommonConst;
import com.pch.common.api.model.PageResult;
import com.pch.common.api.param.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author pch 651158394@qq.com
 * @version 2021/6/25 上午8:45
 */
@Service
@Slf4j
public class ResourcesService {

    private static final String FILE_DIR_JSON = "json";
    private static final String FILE_DIR_IMG = "img";
    private static final String FILE_DIR_FILE = "file";
    private static final String FILE_SUFFIX_JSON = "json";
    private static final String FILE_SUFFIX_SYMBOL = ".";
    private static final String CHAR_ID_JOIN_SYMBOL = "_";
    private String publicUrlPrefix;
    private String uploadJsonPath;
    private String uploadImgPath;
    private String uploadFilePath;
    private String uriPrefix;

    public ResourcesService(
            @Value("${com.pch.resources.public-url-prefix:./}") String publicUrlPrefix,
            @Value("${com.pch.resources.upload-path:./}") String uploadPath,
            @Value("${com.pch.resources.uri-prefix:upload/}") String uriPrefix
    ) {
        this.publicUrlPrefix = publicUrlPrefix;
        this.uploadJsonPath = uploadPath + FILE_DIR_JSON + File.separator;
        this.uploadImgPath = uploadPath + FILE_DIR_IMG + File.separator;
        this.uploadFilePath = uploadPath + FILE_DIR_FILE + File.separator;
        this.uriPrefix = uriPrefix;
    }

    public int saveJson(JSONObject json) {
        return saveJsonFile(JSONUtil.toJsonStr(json).getBytes(), null);
    }

    public int uploadJson(JSONObject json, String id) {
        return saveJsonFile(JSONUtil.toJsonStr(json).getBytes(), id);
    }

    public JSONObject findJson(String id) {
        final String jsonName = id.contains(FILE_SUFFIX_SYMBOL) ? id : (id + FILE_SUFFIX_SYMBOL + FILE_SUFFIX_JSON),
                filePath = this.uploadJsonPath + jsonName;
        final File file = new File(filePath);
        log.info("filePath: {}", filePath);
        try (FileInputStream fis = new FileInputStream(file)) {
            byte[] bytes = new byte[fis.available()];
            int read = fis.read(bytes);
            log.info("read: {}", read);
            return JSONUtil.parseObj(new String(bytes));
        } catch (Exception e) {
            log.error("", e);
            return null;
        }
    }

    public PageResult<String> listFile(Page page) {
        return list(page, this.uploadFilePath, FILE_DIR_FILE);
    }

    public PageResult<String> listImg(Page page) {
        return list(page, this.uploadImgPath, FILE_DIR_IMG);
    }

    public PageResult<String> list(Page page, String filePath, String dir) {
        File[] files = Objects.requireNonNull(new File(filePath).listFiles());
        return new PageResult<>(
                files.length,
                Arrays.stream(files)
                        .skip(page.getLimit() * (page.getPage() - 1))
                        .limit(page.getLimit())
                        .map(file -> publicUrlPrefix + uriPrefix + dir + "/" + file.getName())
                        .collect(Collectors.toList())
        );
    }

    public int saveFile(byte[] bytes, String id, String fileName, String fileSuffix) {
        return saveFile(this.uploadFilePath, bytes, id, fileName, fileSuffix);
    }

    private int saveJsonFile(byte[] bytes, String id) {
        return saveFile(this.uploadJsonPath, bytes, id, FILE_SUFFIX_JSON);
    }

    public int saveImgFile(byte[] bytes, String id, String fileSuffix) {
        return saveFile(this.uploadImgPath, bytes, id, fileSuffix);
    }

    private int saveFile(String fileDir, byte[] bytes, String id, String fileSuffixName) {
        return saveFile(fileDir, bytes, id, null, fileSuffixName);
    }

    private int saveFile(String fileDir, byte[] bytes, String id, String fileName, String fileSuffixName) {
        File dest;
        // 更新文件，所以检查文件是否存在
        if (null != id) {
            dest = getFileFromId(fileDir, id, fileSuffixName);
            if (!dest.exists()) {
                log.info("file not exists, path: {}", dest.getAbsoluteFile());
                return ErrorCode.FILE_ALREADY_EXISTS;
            }
            // 保存文件，如果文件冲突，则自增
        } else {
            dest = null != fileName ? new File(fileDir, fileName + fileSuffixName) : getUniqueFile(fileDir, fileSuffixName);
        }
        if (!dest.getParentFile().exists()) {
            final boolean createSuccess = dest.getParentFile().mkdirs();
            if (!createSuccess) {
                return ErrorCode.FILE_CREATE_FAILED;
            }
        }
        try (FileOutputStream fos = new FileOutputStream(dest)) {
            fos.write(bytes);
            fos.flush();
        } catch (IOException e) {
            log.error("", e);
            return ErrorCode.FILE_WRITE_FAILED;
        }
        return CommonConst.RESULT_CODE_OK;
    }

    private File getFileFromId(String fileDir, String id, String fileSuffixName) {
        return new File(fileDir + id + FILE_SUFFIX_SYMBOL + fileSuffixName);
    }

    private File getUniqueFile(String fileDir, String fileSuffixName) {
        String id = null, fileName = null, filePath = null;
        File dest;
        do {
            fileName = (id = getUniqueId(id)) + FILE_SUFFIX_SYMBOL + fileSuffixName;
            filePath = fileDir + fileName;
            dest = new File(filePath);
        } while (dest.exists());
        log.info("id: {}, fileName: {}, filePath: {}", id, fileName, filePath);
        return dest;
    }

    private String getUniqueId(String id) {
        return null == id ? getId() : nextId(id);
    }

    private String getId() {
        return new BigDecimal(System.currentTimeMillis()).toPlainString();
    }

    private String nextId(String id) {
        String[] idArr = id.split(CHAR_ID_JOIN_SYMBOL, -1);
        if (idArr.length <= 1) {
            return id + CHAR_ID_JOIN_SYMBOL + 0;
        } else {
            return id + CHAR_ID_JOIN_SYMBOL + (Integer.parseInt(idArr[1]) + 1);
        }
    }

    public PageResult<String> listJson(Page page) {
        File[] files = Objects.requireNonNull(new File(this.uploadJsonPath).listFiles());
        return new PageResult<>(
                files.length,
                Arrays.stream(files)
                        .skip(page.getLimit() * (page.getPage() - 1))
                        .limit(page.getLimit())
                        .map(file -> file.getName().substring(0, file.getName().lastIndexOf(".")))
                        .collect(Collectors.toList())
        );
    }
}
