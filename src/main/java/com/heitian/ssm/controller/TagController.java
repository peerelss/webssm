package com.heitian.ssm.controller;

import com.alibaba.fastjson.JSON;
import com.heitian.ssm.model.Tag;
import com.heitian.ssm.model.TumblrModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by root on 17-4-5.
 * tag 管理类，用于请求最近常用的tag和根据字母变化tag
 */
@Controller
@RequestMapping("/tumblr")
public class TagController {
    @RequestMapping("/tag/{str}")
    public void test4(HttpServletResponse response, @PathVariable(value = "str") String str) throws Exception{
        try {
            Tag user = new Tag("getFastJson",1);
            //把对象序列化为json类型
            String json = JSON.toJSONString(user);
            //设置响应类型和编码类型
            response.setContentType("application/json;charset=UTF-8");
            //把json响应回页面
            response.getWriter().print(json);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
