package com.pch.manage.controller;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
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
@RequestMapping("junit")
@Slf4j
@AllArgsConstructor
public class JunitController {

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

    @PostMapping("upload")
    @ResponseBody
    public JSONObject upload(
            @RequestParam(value = "file", required = false) MultipartFile[] fileList,
            @ModelAttribute JunitBean junitBean) {
        log.info(JSONUtil.toJsonStr(junitBean));
        JSONObject jsonObject = JSONUtil.parseObj(junitBean);
        if (null != fileList) {
            jsonObject.set("fileList", Arrays.stream(fileList).map(file -> {
                JSONObject obj = JSONUtil.createObj();
                obj.set("name", file.getOriginalFilename());
                try {
                    obj.set("length", file.getBytes().length);
                } catch (IOException e) {
                    log.error("", e);
                }
                return obj;
            }).collect(Collectors.toList()));
            jsonObject.set("fileList.length", fileList.length);
        }
        return jsonObject;
    }
}
