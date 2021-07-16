package com.pch.manage.controller.upload.tools;

import com.pch.common.api.cons.CommonConst;
import com.pch.manage.param.QrInfo;
import com.pch.manage.service.tools.BusinessService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author pch 651158394@qq.com
 * @version 2021/7/10 下午12:20
 */
@Controller
@RequestMapping("upload/tools/business")
@Slf4j
@AllArgsConstructor
public class BusinessUploadController {

    private BusinessService businessService;

    @PostMapping("editTemplate")
    public ResponseEntity<byte[]> editTemplate(
            @RequestParam(value = "file", required = false) MultipartFile[] fileList,
            @ModelAttribute QrInfo qrInfo
    ) {
        if (null != fileList && fileList.length > 0) {
            MultipartFile file = fileList[0];
            String originalFilename = file.getOriginalFilename();
            int index;
            if (originalFilename != null && (index = originalFilename.lastIndexOf(CommonConst.STRING_DOT)) >= 0) {
                String imgExtension = originalFilename.substring(index + 1);
                qrInfo.setImgExtension(imgExtension);
            } else {
                qrInfo.setImgExtension("png");
            }
            try {
                qrInfo.setBackgroundImgBytes(file.getBytes());
            } catch (IOException e) {
                log.error("", e);
            }
        }
        businessService.setQrInfo(qrInfo);
        byte[] bytes = businessService.mergeImage(null, "https://www.baidu.com", "姓名", "部门");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("image", businessService.defaultConfig().getImgExtension()));
        return new ResponseEntity<>(bytes, headers, HttpStatus.OK);
    }

    @PostMapping("merge")
    public ResponseEntity<byte[]> mergeImage(
            @RequestParam(value = "file", required = false) MultipartFile[] fileList,
            @RequestParam(required = false) String url,
            @RequestParam String name,
            @RequestParam String describe,
            HttpServletResponse response
    ) {
        byte[] bytes = new byte[0];
        try {
            InputStream inputStream = null;
            if (null != fileList && fileList.length > 0) {
                inputStream = fileList[0].getInputStream();
            }
            if (null != inputStream || null != url) {
                bytes = businessService.mergeImage(
                        inputStream,
                        url,
                        name,
                        describe
                );
                response.setStatus(HttpStatus.OK.value());
            }
        } catch (IOException e) {
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            log.error("", e);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("image", businessService.defaultConfig().getImgExtension()));
        return new ResponseEntity<>(bytes, headers, HttpStatus.OK);
    }

    /*@GetMapping("card")
    public ResponseEntity<byte[]> card() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<>(BusinessController.bytes, headers, HttpStatus.OK);
    }*/
}
