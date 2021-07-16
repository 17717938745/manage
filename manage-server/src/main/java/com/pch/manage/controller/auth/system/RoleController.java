package com.pch.manage.controller.auth.system;

import com.pch.common.api.bean.ErrorCode;
import com.pch.common.api.model.DataResult;
import com.pch.common.api.model.ItemResult;
import com.pch.common.api.model.Result;
import com.pch.system.api.SystemApi;
import com.pch.system.api.entity.Role;
import com.pch.system.api.param.RelateRole;
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
@RequestMapping("auth/role")
@Slf4j
@AllArgsConstructor
public class RoleController {

    private SystemApi systemApi;

    @PostMapping("list")
    public Result list() {
        return new ItemResult<>(ErrorCode.SAVE_FAIL, systemApi.roleApi().list());
    }

    @PostMapping("save")
    public Result save(@RequestBody Role role) {
        return new DataResult<>(ErrorCode.SAVE_FAIL, systemApi.roleApi().save(role));
    }

    @PostMapping("update")
    public Result update(@RequestBody Role role) {
        return new DataResult<>(ErrorCode.UPDATE_FAIL, systemApi.roleApi().update(role));
    }

    @PostMapping("delete")
    public Result delete(@RequestBody List<Role> roleList) {
        return new ItemResult<>(ErrorCode.UPDATE_FAIL, systemApi.roleApi().delete(roleList));
    }

    @PostMapping("relate/list")
    public Result relate(@RequestBody Role role) {
        return new ItemResult<>(ErrorCode.LIST_FAIL, systemApi.roleApi().relateList(role));
    }

    @PostMapping("relate/refresh")
    public Result relateRefresh(@RequestBody RelateRole relateRole) {
        return new ItemResult<>(ErrorCode.LIST_FAIL, systemApi.roleApi().relateRefresh(relateRole));
    }
}
