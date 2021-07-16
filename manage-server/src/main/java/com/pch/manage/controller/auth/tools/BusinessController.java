package com.pch.manage.controller.auth.tools;

import com.pch.common.api.bean.ErrorCode;
import com.pch.common.api.model.DataResult;
import com.pch.common.api.model.Result;
import com.pch.manage.service.tools.BusinessService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author pch 651158394@qq.com
 * @version 2021/7/10 下午12:20
 */
@Controller
@RequestMapping("auth/tools/business")
@Slf4j
@AllArgsConstructor
public class BusinessController {

    private BusinessService businessService;

    @PostMapping("defaultConfig")
    @ResponseBody
    public Result defaultConfig() {
        return new DataResult<>(ErrorCode.LOCATE_FAIL, businessService.defaultConfig());
    }

    /*@GetMapping("card")
    public ResponseEntity<byte[]> card() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<>(BusinessController.bytes, headers, HttpStatus.OK);
    }*/
}
