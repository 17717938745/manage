package com.pch.manage.controller;

import cn.hutool.json.JSONUtil;
import com.pch.common.api.bean.ErrorCode;
import com.pch.common.api.model.DataResult;
import com.pch.common.api.model.Result;
import com.pch.system.api.SystemApi;
import com.pch.system.api.param.SignIn;
import com.pch.system.api.param.SignOut;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author pch 651158394@qq.com
 * @version 2020/7/28 10:34 上午
 */
@Controller
@RequestMapping("login")
@Slf4j
@AllArgsConstructor
public class LoginController {

    private SystemApi systemApi;

    @PostMapping("requestPassCode")
    @ResponseBody
    public String requestPassCode(HttpServletRequest request) {
        final String deviceId = request.getHeader("Device-Id");
        return systemApi.requestPassCode(deviceId);
    }

    @PostMapping("signIn")
    @ResponseBody
    public Result signIn(HttpServletRequest request, @RequestBody SignIn signIn) {
        final String deviceId = request.getHeader("Device-Id");
        signIn.setDeviceId(deviceId);
        return new DataResult<>(ErrorCode.SIGN_IN_FAIL, systemApi.signIn(signIn));
    }

    @PostMapping("signOut")
    @ResponseBody
    public Result signOut(HttpServletRequest request) {
        final String deviceId = request.getHeader("Device-Id"),
                passCode = request.getHeader("Pass-Code");
        final SignOut signOut = new SignOut();
        signOut.setDeviceId(deviceId);
        signOut.setPassCode(passCode);
        if (systemApi.signOut(signOut)) {
            return new Result();
        } else {
            return new Result(ErrorCode.SIGN_OUT_FAIL);
        }
    }
}
