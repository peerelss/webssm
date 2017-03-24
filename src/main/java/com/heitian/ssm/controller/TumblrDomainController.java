package com.heitian.ssm.controller;

import com.github.pagehelper.PageHelper;
import com.heitian.ssm.model.TumblrDomain;
import com.heitian.ssm.service.TumblrDomainService;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by root on 17-3-22.
 */
@Controller
@RequestMapping("/mybatis")
public class TumblrDomainController {
    @Resource
    private TumblrDomainService mTumblrDomainService;

    @RequestMapping(value="/list/{key}", method = {RequestMethod.GET})
    public void test1(HttpServletResponse response,@PathVariable(value="key") String key) throws Exception{

        ObjectMapper mapper = new  ObjectMapper();
        String json = mapper.writeValueAsString(null);
        //设置响应类型和编码类型
        response.setContentType("application/json;charset=UTF-8");
        //把json响应回页面
        response.getWriter().print(json);

    }
    @RequestMapping(value="/page/{id}", method = {RequestMethod.GET})
    public void getTumblrByPage(HttpServletResponse response,@PathVariable(value="id") int id)throws Exception{
        PageHelper.startPage(id,20);
        List<TumblrDomain> domainList=mTumblrDomainService.selectAllTumblrDomain();
        ObjectMapper mapper = new  ObjectMapper();
        String json = mapper.writeValueAsString(domainList);
        //设置响应类型和编码类型
        response.setContentType("application/json;charset=UTF-8");
        //把json响应回页面
        response.getWriter().print(json);
    }
}
