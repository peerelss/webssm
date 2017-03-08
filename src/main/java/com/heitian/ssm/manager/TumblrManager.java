package com.heitian.ssm.manager;


import com.heitian.ssm.service.TumblrService;
import com.heitian.ssm.service.UserService;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;


/**
 * Created by root on 17-3-6.
 */
public class TumblrManager {

    private static TumblrManager ourInstance = new TumblrManager();
    public static TumblrManager getInstance() {
        return ourInstance;
    }
    private TumblrManager() {
    }

}
