package com.heitian.ssm.controller;

import com.heitian.ssm.model.TumblrModel;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by root on 17-3-22.
 */
@Controller
@RequestMapping("/test/mybatis")
public class TestMybatisController {
    @RequestMapping(value="/list/{key}", method = {RequestMethod.GET})
    public void test1(HttpServletResponse response,@PathVariable(value="key") String key) throws Exception{

        ObjectMapper mapper = new  ObjectMapper();
        String json = mapper.writeValueAsString(null);
        //设置响应类型和编码类型
        response.setContentType("application/json;charset=UTF-8");
        //把json响应回页面
        response.getWriter().print(json);

    }
}
