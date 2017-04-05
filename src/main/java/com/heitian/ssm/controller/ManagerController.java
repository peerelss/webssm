package com.heitian.ssm.controller;

import com.heitian.ssm.conf.Constance;
import com.heitian.ssm.manager.TumblrManager;
import com.heitian.ssm.model.Tag;
import com.heitian.ssm.model.TumblrModel;
import com.heitian.ssm.service.TagService;
import com.heitian.ssm.service.TumblrService;
import com.heitian.ssm.utils.ClassUtil;
import com.heitian.ssm.utils.FIleUtil;
import com.heitian.ssm.utils.StringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.io.File;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 17-3-13.
 */
@Controller
@RequestMapping("/manager")
public class ManagerController {
    @Resource
    private TumblrService mTumblrService;
    @Resource
    private TagService mTagService;

    @RequestMapping("/tumblr2txt")
    @ResponseBody
    public String writeDB2Txt(){

        List<Tag> tags=new ArrayList<>();
        tags.add(new Tag("test3",0,new Timestamp(new java.util.Date().getTime())));
        tags.add(new Tag("test4",0,new Timestamp(new java.util.Date().getTime())));
       // mTagService.addTagList()

        return 0+"";
    }
    //
}
