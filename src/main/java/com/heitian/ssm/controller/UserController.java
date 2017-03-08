package com.heitian.ssm.controller;

import com.heitian.ssm.model.User;
import com.heitian.ssm.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Zhangxq on 2016/7/15.
 */

@Controller
@RequestMapping("/user")
public class UserController {

    private Logger log = Logger.getLogger(UserController.class);
    @Resource
    private UserService userService;

    @RequestMapping("/showUser")
    public String showUser(HttpServletRequest request, Model model){
        log.info("查询所有用户信息");
        List<User> userList = userService.getAllUser();
        model.addAttribute("userList",userList);
        return "showUser";
    }
    @RequestMapping(value="/detail/{id}", method = {RequestMethod.GET})
    @ResponseBody
    public String getDetail(@PathVariable(value="id") Integer id){
        return id+"";
    }
    @RequestMapping(value="/details/{id}", method = {RequestMethod.GET})
    @ResponseBody
    public String getDetailJson(@PathVariable(value="id") Integer id){
        User user=userService.getUserById(Long.valueOf(id));
        return user.getUserName();
    }

    @RequestMapping("/showJpg")
    public String showJpg(HttpServletRequest request){
        return "image";
    }
    @RequestMapping("/showVue")
    public String showVue(HttpServletRequest request){
        return "testvue";
    }
}
