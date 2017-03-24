package com.heitian.ssm.service.impl;

import com.heitian.ssm.dao.TumblrDomainDao;
import com.heitian.ssm.model.TumblrDomain;
import com.heitian.ssm.service.TumblrDomainService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by root on 17-3-24.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class TumblrDomainServiceImpl implements TumblrDomainService{
    @Resource
    private TumblrDomainDao mTumblrDomainDao;
    public List<TumblrDomain> selectAllTumblrDomain() {
        return mTumblrDomainDao.selectAllTumblrDomain();
    }
}
