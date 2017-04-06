package com.heitian.ssm.service;

import com.heitian.ssm.model.Tag;

import java.util.List;

/**
 * Created by root on 17-4-1.
 */
public interface TagService {
    int addBatch(List<Tag> tags);
    List<Tag> selectTagByName(String name);
}
