package com.pch.manage.controller.auth.system;

import cn.hutool.json.JSONObject;
import com.pch.common.api.bean.ErrorCode;
import com.pch.common.api.model.DataResult;
import com.pch.common.api.model.ItemResult;
import com.pch.common.api.model.Result;
import com.pch.system.api.SystemApi;
import com.pch.system.api.entity.Role;
import com.pch.system.api.entity.User;
import com.pch.system.api.param.RelateUser;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pch 651158394@qq.com
 * @version 2021/7/1 上午11:06
 */
@RestController
@RequestMapping("auth/user")
@Slf4j
@AllArgsConstructor
public class UserController {

    private SystemApi systemApi;

    @PostMapping("list")
    public Result list(@RequestBody JSONObject jsonObject) {
        return new ItemResult<>(ErrorCode.SAVE_FAIL, systemApi.userApi().list());
    }

    @PostMapping("save")
    public Result save(@RequestBody User user) {
        return new DataResult<>(ErrorCode.SAVE_FAIL, systemApi.userApi().save(user));
    }

    @PostMapping("update")
    public Result update(@RequestBody User user) {
        return new DataResult<>(ErrorCode.UPDATE_FAIL, systemApi.userApi().update(user));
    }

    @PostMapping("delete")
    public Result delete(@RequestBody List<User> userList) {
        return new ItemResult<>(ErrorCode.UPDATE_FAIL, systemApi.userApi().delete(userList));
    }

    @PostMapping("relate/list")
    public Result relate(@RequestBody User user) {
        return new ItemResult<>(ErrorCode.LIST_FAIL, systemApi.userApi().relateList(user));
    }

    @PostMapping("relate/refresh")
    public Result relateRefresh(@RequestBody RelateUser relateUser) {
        return new ItemResult<>(ErrorCode.LIST_FAIL, systemApi.userApi().relateRefresh(relateUser));
    }
}
