package com.pch.manage.controller.auth.resouces;

import cn.hutool.json.JSONObject;
import com.pch.common.api.model.PageResult;
import com.pch.common.api.model.Result;
import com.pch.common.api.param.Page;
import com.pch.html.api.param.HtmlJson;
import com.pch.manage.service.ResourcesService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @author pch 651158394@qq.com
 * @version 2020/7/28 10:34 上午
 */
@RestController
@RequestMapping("auth/resources/json")
@Slf4j
@AllArgsConstructor
public class JsonController {

    private ResourcesService resourcesService;

    @PostMapping("list")
    public PageResult<String> list(@ModelAttribute Page page) {
        return resourcesService.listJson(page);
    }

    @PostMapping("update")
    public Result update(@RequestBody HtmlJson<JSONObject> json) {
        return new Result(resourcesService.uploadJson(json.getData(), json.getId()));
    }

    @PostMapping("save")
    public Result save(@RequestBody JSONObject json) {
        return new Result(resourcesService.saveJson(json));
    }
}
