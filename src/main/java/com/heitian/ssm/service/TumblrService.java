package com.heitian.ssm.service;

import com.heitian.ssm.model.TumblrModel;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by root on 17-3-6.
 */

public interface TumblrService {

    List<TumblrModel> getAllTumblr();

    TumblrModel getTumblrByName(String emailOrPhone, Short state);

    TumblrModel getTumblrById(int id);

    long addTumblr(TumblrModel tumblrModel);

    void deleteTumblr(int id);
    void updateTumblr(TumblrModel tumblrModel);
}
