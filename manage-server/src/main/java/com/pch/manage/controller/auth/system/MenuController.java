package com.pch.manage.controller.auth.system;

import com.pch.common.api.bean.ErrorCode;
import com.pch.common.api.model.DataResult;
import com.pch.common.api.model.ItemResult;
import com.pch.common.api.model.Result;
import com.pch.system.api.SystemApi;
import com.pch.system.api.entity.Menu;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author pch 651158394@qq.com
 * @version 2021/7/1 上午11:06
 */
@RestController
@RequestMapping("auth/menu")
@Slf4j
@AllArgsConstructor
public class MenuController {

    private SystemApi systemApi;

    @PostMapping("list")
    public Result list() {
        return new ItemResult<>(ErrorCode.SAVE_FAIL, systemApi.menuApi().list());
    }

    @PostMapping("save")
    public Result save(@RequestBody Menu menu) {
        return new DataResult<>(ErrorCode.SAVE_FAIL, systemApi.menuApi().save(menu));
    }

    @PostMapping("update")
    public Result update(@RequestBody Menu menu) {
        return new DataResult<>(ErrorCode.UPDATE_FAIL, systemApi.menuApi().update(menu));
    }

    @PostMapping("delete")
    public Result delete(@RequestBody List<Menu> menuList) {
        return new ItemResult<>(ErrorCode.UPDATE_FAIL, systemApi.menuApi().delete(menuList));
    }
}
