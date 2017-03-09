package com.heitian.ssm.test;

import com.heitian.ssm.model.TumblrModel;
import com.heitian.ssm.service.TumblrService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.annotation.Resource;
import java.io.InputStream;
import java.util.List;

/**
 * Created by root on 17-3-8.
 */
public class TestMybatis {
    @Resource
    public static TumblrService mTumblrService;
    public static void main(String[] args) {
        getAllTumblr();
    }
    public static void getAllTumblr(){
        List<TumblrModel> list=mTumblrService.getAllTumblr();
        for(TumblrModel tumblrModel:list){
            System.out.println(tumblrModel.getId());
        }
    }
}
