package com.heitian.ssm.dao;

import com.heitian.ssm.model.Tag;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by root on 17-3-23.
 */
@Repository
public interface TagDao {
    int addBatch(List<Tag> tags);
}
