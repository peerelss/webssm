package com.heitian.ssm.controller;

import com.heitian.ssm.model.TumblrModel;
import com.heitian.ssm.service.TumblrService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
/**
 * Created by kevin on 2017/1/16.
 * 获取tumblr博客的类型，并插入数据库
 */
@Controller
@RequestMapping("/tumblr")
public class TumblrController {
    @Resource
    private TumblrService mTumblrService;
    @RequestMapping("/add2tumblr")
    public String showJpg(HttpServletRequest request){
        return "/tumblr/add2tumblr";
    }

    @RequestMapping("/add2TumblrDB")
    @ResponseBody
    public String add2DB(){
        return "/tumblr/add2tumblr";
    }

    @RequestMapping("/addTumblr")
    @ResponseBody
    public String add2Tumblr(String name,String tag,String level){
        if(null==name||"".equals(name)){
            return "error";
        }else {
            System.out.println("name = "+name+" tag = "+tag+"  level  ="+level);
            TumblrModel tumblrModel=new TumblrModel(name,tag,level);
            mTumblrService.addTumblr(tumblrModel);
            System.out.println("long = "+tumblrModel.getId());
            return "success";
        }
    }
    @RequestMapping(value="/delete/{id}", method = {RequestMethod.GET})
    @ResponseBody
    public String getDetail(@PathVariable(value="id") Long id){
        mTumblrService.deleteTumblr(id);
        return "success"+" id = "+id;
    }
}
