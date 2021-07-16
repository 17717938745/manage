package com.pch.manage.controller.auth;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.pch.manage.controller.JunitBean;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author pch 651158394@qq.com
 * @version 2020/7/28 10:34 上午
 */
@Controller
@RequestMapping("auth/junit")
@Slf4j
@AllArgsConstructor
public class AuthJunitController {

    @GetMapping("get")
    @ResponseBody
    public JSONObject get(@ModelAttribute JunitBean junitBean) {
        log.info(JSONUtil.toJsonStr(junitBean));
        return JSONUtil.parseObj(junitBean);
    }

    @PostMapping("post")
    @ResponseBody
    public JSONObject post(@ModelAttribute JunitBean junitBean) {
        log.info(JSONUtil.toJsonStr(junitBean));
        return JSONUtil.parseObj(junitBean);
    }

    @PostMapping("postJson")
    @ResponseBody
    public JSONObject postJson(@RequestBody JunitBean junitBean) {
        log.info(JSONUtil.toJsonStr(junitBean));
        return JSONUtil.parseObj(junitBean);
    }
}
