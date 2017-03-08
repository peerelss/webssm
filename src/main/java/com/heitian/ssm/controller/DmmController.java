package com.heitian.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by kevin on 2017/1/16.
 * 使用这个页面来处理
 */
@Controller
@RequestMapping("/dmm")
public class DmmController {
    @RequestMapping("/showJpg")
    public String showJpg(HttpServletRequest request){
        return "image";
    }
}
