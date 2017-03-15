package com.heitian.ssm.manager;


import com.heitian.ssm.model.TumblrModel;
import com.heitian.ssm.service.TumblrService;
import com.heitian.ssm.service.UserService;
import com.heitian.ssm.utils.ClassUtil;
import com.heitian.ssm.utils.FIleUtil;
import com.heitian.ssm.utils.StringUtil;
import org.springframework.stereotype.Controller;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by root on 17-3-6.
 * 用于增删改查tumblr数据的管理类
 */
public class TumblrManager {
    @Resource
    private TumblrService mTumblrService;

    private static TumblrManager ourInstance = new TumblrManager();
    public static TumblrManager getInstance() {
        return ourInstance;
    }
    private TumblrManager() {
    }
    public void tumblrDB2Txt(){
        List<TumblrModel> models=mTumblrService.getAllTumblr();
        FIleUtil.putStringToTxt("../assets/tumblr_db.txt", StringUtil.list2String(ClassUtil.tumblrModelList2StringList(models)));
    }
    public String tumblrList2String(){
        List<TumblrModel> models=mTumblrService.getAllTumblr();
        if(models==null){
            return "null";
        }
        return StringUtil.list2String(ClassUtil.tumblrModelList2StringList(mTumblrService.getAllTumblr()));
    }
}
