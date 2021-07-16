package com.pch.manage.controller;

import com.pch.manage.service.ResourcesService;
import com.pch.system.api.SystemApi;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author pch 651158394@qq.com
 * @version 2020/7/28 10:34 上午
 */
@Controller
@RequestMapping("")
@Slf4j
@AllArgsConstructor
public class IndexController {

    private ResourcesService resourcesService;

    @GetMapping("dynamic/{id}")
    public ModelAndView index(HttpServletRequest request, ModelMap map, @PathVariable(name = "id") String id) {
        ModelAndView modelAndView = new ModelAndView();
        final String viewName = "dynamic";
        modelAndView.setViewName(viewName);
        map.put("scriptForHtmlJson", "<script type=\"text/javascript\">window.PCH_SCOPE_HTML_JSON = " + resourcesService.findJson(id).toString() + "</script>");
        return modelAndView;
    }
}
