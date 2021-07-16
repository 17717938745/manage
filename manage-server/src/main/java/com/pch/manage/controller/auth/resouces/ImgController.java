package com.pch.manage.controller.auth.resouces;

import com.pch.common.api.model.PageResult;
import com.pch.common.api.param.Page;
import com.pch.manage.service.ResourcesService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author pch 651158394@qq.com
 * @version 2020/7/28 10:34 上午
 */
@RestController
@RequestMapping("auth/resources/img")
@Slf4j
@AllArgsConstructor
public class ImgController {

    private ResourcesService resourcesService;

    @PostMapping("list")
    public PageResult<String> list(@ModelAttribute Page page) {
        return resourcesService.listImg(page);
    }
}
