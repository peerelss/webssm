package com.heitian.ssm.dao;

import com.heitian.ssm.model.TumblrDomain;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by root on 17-3-24.
 */
@Repository
public interface TumblrDomainDao {
    List<TumblrDomain> selectAllTumblrDomain();
}
