package com.heitian.ssm.controller;

import com.alibaba.fastjson.JSON;
import com.heitian.ssm.model.TumblrDomain;
import com.heitian.ssm.model.TumblrModel;
import com.heitian.ssm.service.TumblrDomainService;
import com.heitian.ssm.service.TumblrService;
import com.heitian.ssm.utils.ClassUtil;
import com.heitian.ssm.utils.FIleUtil;
import com.heitian.ssm.utils.StringUtil;
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
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kevin on 2017/1/16.
 * 获取tumblr博客的类型，并插入数据库
 */
@Controller
@RequestMapping("/tumblr")
public class TumblrController {
    @Resource
    private TumblrService mTumblrService;
    @Resource
    private TumblrDomainService mTumblrDomainService;

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
    public String add2Tumblr(String name,String tag,int level){
        if(null==name||"".equals(name)){
            return "error";
        }else {
            List<TumblrDomain> tumblrDomains=mTumblrDomainService.selectTumblrListByName(name);
            if(tumblrDomains!=null&&tumblrDomains.size()>0){
                return  name+" is exist";
            }else {
                System.out.println("name = "+name+" tag = "+tag+"  level  ="+level);
                TumblrDomain tumblrModel=new TumblrDomain(name,tag,level);
                mTumblrDomainService.addTumblrDomain(tumblrModel);
                System.out.println("long = "+tumblrModel.getId());
                return "success";
            }
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

    @RequestMapping(value="/showByName/{name}", method = {RequestMethod.GET})
    @ResponseBody
    public String showTumblrByName(@PathVariable(value="name") String name){
        List<TumblrModel> model=mTumblrService.getTumblrListByName(name);
        if(model!=null||model.size()>0){
           return model.toString();
        }else {
            return "name = "+name+" is not exist";
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
        tumblrModels[1]=  new TumblrModel("getJackson", "张晓晓","1");
        ObjectMapper mapper = new  ObjectMapper();
        String json = mapper.writeValueAsString(tumblrModels);
        //设置响应类型和编码类型
        response.setContentType("application/json;charset=UTF-8");
        //把json响应回页面
        response.getWriter().print(json);

    }

    @RequestMapping("/getAllTumblr")
    @ResponseBody
    public String getAllTumblr(){
        return StringUtil.list2String(ClassUtil.tumblrModelList2StringList(mTumblrService.getAllTumblr()));
    }
    @RequestMapping("/getJsonList")
    public void test5(HttpServletResponse response) throws Exception{
        try {
            //把对象序列化为json类型
            String json = JSON.toJSONString(mTumblrService.getAllTumblr());
            //设置响应类型和编码类型
            response.setContentType("application/json;charset=UTF-8");
            //把json响应回页面
            response.getWriter().print(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value="/update", method = {RequestMethod.GET})
    @ResponseBody
    public String updateTumblr(String name,String tags,String level,int id){
        if(name==null){
            return "error";
        }
        TumblrModel model1=mTumblrService.getTumblrById(id);
        if(model1==null){
            mTumblrService.addTumblr(new TumblrModel(name,tags,level));
            return "insert success";
        }else {
            TumblrModel model=new TumblrModel(id,name,tags,level);
            mTumblrService.updateTumblr(model);
            return "update success";
        }
    }
    @RequestMapping(value="/edit/{str1}/to/{str2}", method = {RequestMethod.GET})
    @ResponseBody
    public String editWrong2Right(HttpServletResponse response,@PathVariable(value="str1") String str1,@PathVariable(value = "str2") String str2){
        List<TumblrDomain> list=mTumblrDomainService.selectTumblrListByTag(str1);
        if(list==null||list.size()==0){
            return "tag 为 "+str1+" 下，列表为空";
        }else {
            for(TumblrDomain domain:list){
                domain.setTag(str2);
                mTumblrDomainService.updateTumblrDomain(domain);
            }
            return "修改 "+list.size()+" 个/n<br>" +list.toString();
        }
    }
    @RequestMapping(value="/detail/{id}", method = {RequestMethod.GET})
    public void showTumblrDetail(HttpServletResponse response,@PathVariable(value="id") int id){
        try {
            TumblrModel user = mTumblrService.getTumblrById(id);
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
