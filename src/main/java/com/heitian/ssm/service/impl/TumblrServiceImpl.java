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

    @Override
    public   List<TumblrModel> getTumblrListByName(String name){
        return mTumblrDao.selectTumblrByName(name);
    }
    @Override
    public List<TumblrModel> getAllTumblr() {
        return mTumblrDao.selectAllTumblr();
    }

    @Override
    public TumblrModel getTumblrByName(String emailOrPhone, Short state) {
        return mTumblrDao.selectTumblrByPhoneOrEmail(emailOrPhone, state);
    }
    @Override
    public TumblrModel getTumblrById(int id) {
        return mTumblrDao.selectTumblrById(id);
    }

    @Override
    public long addTumblr(TumblrModel tumblrModel) {
        return mTumblrDao.addTumblr(tumblrModel);
    }
    @Override
    public void deleteTumblr(int id) {
        mTumblrDao.deleteTumblr(id);
    }
    @Override
    public void updateTumblr(TumblrModel model){
        mTumblrDao.updateTumblr(model);
    }
}
