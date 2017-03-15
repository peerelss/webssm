package com.heitian.ssm.controller;

import com.heitian.ssm.manager.TumblrManager;
import com.heitian.ssm.model.TumblrModel;
import com.heitian.ssm.service.TumblrService;
import com.heitian.ssm.utils.ClassUtil;
import com.heitian.ssm.utils.StringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by root on 17-3-13.
 */
@Controller
@RequestMapping("/manager")
public class ManagerController {
    @Resource
    private TumblrService mTumblrService;
    @RequestMapping("/tumblr2txt")
    @ResponseBody
    public String writeDB2Txt(){

        List<TumblrModel> models=mTumblrService.getAllTumblr();
        if(models==null){
            return "null";
        }else {

        }
        return StringUtil.list2String(ClassUtil.tumblrModelList2StringList(mTumblrService.getAllTumblr()));
    }
}
