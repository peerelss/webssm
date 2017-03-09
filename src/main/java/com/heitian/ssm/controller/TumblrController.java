package com.heitian.ssm.controller;

import com.alibaba.fastjson.JSON;
import com.heitian.ssm.model.TumblrModel;
import com.heitian.ssm.service.TumblrService;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
    public String deleteTumblr(@PathVariable(value="id") int id){
        TumblrModel model=mTumblrService.getTumblrById(id);
        if(model!=null){
            mTumblrService.deleteTumblr(id);
            return "success"+"delete id = "+id;
        }else {
            return "id = "+id+" not exist";
        }
    }

    @RequestMapping(value="/show/{id}", method = {RequestMethod.GET})
    @ResponseBody
    public String showTumblr(@PathVariable(value="id") int id){
        TumblrModel model=mTumblrService.getTumblrById(id);
        if(model!=null){
            mTumblrService.deleteTumblr(id);
            return "success"+"delete id = "+id;
        }else {
            return "id = "+id+" not exist";
        }
    }

    @RequestMapping(value="/show/", method = {RequestMethod.GET})
    @ResponseBody
    public String showAll(){
         return "";
    }

    @RequestMapping("/getJson")
    public void test4(HttpServletResponse response) throws Exception{
        try {
            TumblrModel user = new TumblrModel("getFastJson", "张晓晓","1");
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
    @RequestMapping("/getGson")
    public void test3(HttpServletResponse response) throws Exception{

        TumblrModel user = new TumblrModel("getJackson", "张晓晓","1");
        ObjectMapper mapper = new  ObjectMapper();
        String json = mapper.writeValueAsString(user);
        //设置响应类型和编码类型
        response.setContentType("application/json;charset=UTF-8");
        //把json响应回页面
        response.getWriter().print(json);

    }
    @RequestMapping("/getJsons")
    public void test2(HttpServletResponse response) throws Exception{
        try {
            TumblrModel[] tumblrModels=new TumblrModel[2];
            tumblrModels[0] = new TumblrModel("getFastJson", "张晓晓","1");
            tumblrModels[1]=  new TumblrModel("getJackson", "张晓晓","1");
            //把对象序列化为json类型
            String json = JSON.toJSONString(tumblrModels);
            //设置响应类型和编码类型
            response.setContentType("application/json;charset=UTF-8");
            //把json响应回页面
            response.getWriter().print(json);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @RequestMapping("/getGsons")
    public void test1(HttpServletResponse response) throws Exception{
        TumblrModel[] tumblrModels=new TumblrModel[2];
        tumblrModels[0] = new TumblrModel("getFastJson", "张晓晓","1");
        tumblrModels[1]=  new TumblrModel("getJackson", "张晓晓","1");;
        ObjectMapper mapper = new  ObjectMapper();
        String json = mapper.writeValueAsString(tumblrModels);
        //设置响应类型和编码类型
        response.setContentType("application/json;charset=UTF-8");
        //把json响应回页面
        response.getWriter().print(json);

    }
}
