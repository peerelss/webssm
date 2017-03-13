package com.heitian.ssm.controller;

import com.heitian.ssm.service.TumblrService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Created by root on 17-3-13.
 */
@Controller
@RequestMapping("/manager")
public class ManagerController {
    @Resource
    private TumblrService mTumblrService;
    public String writeDB2Txt(){

        return "success";
    }
}
