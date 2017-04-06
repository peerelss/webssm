package com.heitian.ssm.controller;

import com.alibaba.fastjson.JSON;
import com.heitian.ssm.model.Tag;
import com.heitian.ssm.model.TumblrModel;
import com.heitian.ssm.service.TagService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by root on 17-4-5.
 * tag 管理类，用于请求最近常用的tag和根据字母变化tag
 */
@Controller
@RequestMapping("/tag")
public class TagController {
    @Resource
    private TagService mTagService;
    @RequestMapping("/list/{str}")
    public void test4(HttpServletResponse response, @PathVariable(value = "str") String str) throws Exception{
        if(str==null||"".endsWith(str)){
            response.setContentType("application/json;charset=UTF-8");
            //把json响应回页面
            response.getWriter().print("key is null");
            return;
        }
        try {
            List<Tag> tags=mTagService.selectTagByName(str);
            //把对象序列化为json类型
            String json = JSON.toJSONString(tags);
            //设置响应类型和编码类型
            response.setContentType("application/json;charset=UTF-8");
            //把json响应回页面
            response.getWriter().print(json);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
