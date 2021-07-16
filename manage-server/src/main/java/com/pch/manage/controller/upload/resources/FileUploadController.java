package com.pch.manage.controller.upload.resources;

import com.pch.common.api.bean.ErrorCode;
import com.pch.common.api.cons.CommonConst;
import com.pch.common.api.model.Result;
import com.pch.manage.service.ResourcesService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author pch 651158394@qq.com
 * @version 2020/7/28 10:34 上午
 */
@RestController
@RequestMapping("upload/resources/file")
@Slf4j
@AllArgsConstructor
public class FileUploadController {

    private ResourcesService resourcesService;

    /**
     * List<MultipartFile> fileList = ((MultipartHttpServletRequest) request).getFiles("file");
     *
     * @param fileList 略
     */
    @PostMapping("upload")
    public Result upload(@RequestParam("file") MultipartFile[] fileList, HttpServletResponse response) {
        return new Result(Arrays.stream(fileList).map(file -> {
            final String originalFileName = file.getOriginalFilename(),
                    fileSuffix =
                            null == originalFileName ? "file" :
                                    originalFileName.substring(originalFileName.lastIndexOf(".") + 1).toLowerCase();
            try {
                return resourcesService.saveFile(file.getBytes(), null, originalFileName.substring(0, originalFileName.lastIndexOf(".")), fileSuffix);
            } catch (IOException e) {
                log.error("", e);
                return ErrorCode.FILE_WRITE_FAILED;
            }
        }).max(Comparator.naturalOrder()).orElse(CommonConst.RESULT_CODE_OK));
    }
}
