package com.heitian.ssm.service.impl;

import com.heitian.ssm.dao.TumblrDao;
import com.heitian.ssm.model.TumblrModel;
import com.heitian.ssm.service.TumblrService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by root on 17-3-8.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class TumblrServiceImpl implements TumblrService {
    @Resource
    private TumblrDao mTumblrDao;
    private long mId;

    public List<TumblrModel> getAllTumblr() {
        return mTumblrDao.selectAllTumblr();
    }

    public TumblrModel getTumblrByName(String emailOrPhone, Short state) {
        return mTumblrDao.selectTumblrByPhoneOrEmail(emailOrPhone, state);
    }

    public TumblrModel getTumblrById(Long userId) {
        return mTumblrDao.selectTumblrById(userId);
    }

    public long addTumblr(TumblrModel tumblrModel) {
        return mTumblrDao.addTumblr(tumblrModel);
    }

    public void deleteTumblr(long id) {
        mTumblrDao.deleteTumblr(mId);
    }
}
