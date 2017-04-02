package com.heitian.ssm.service.impl;

import com.heitian.ssm.dao.TagDao;
import com.heitian.ssm.dao.TumblrDomainDao;
import com.heitian.ssm.model.Tag;
import com.heitian.ssm.model.TumblrDomain;
import com.heitian.ssm.service.TagService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by root on 17-4-1.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class TagServiceImpl implements TagService{
    @Resource
    private TagDao mTagDao;
    @Override
    public int addBatch(List<Tag> tags) {
        return mTagDao.addBatch(tags);
    }
}
