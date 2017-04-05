package com.heitian.ssm.dao;

import com.heitian.ssm.model.TumblrDomain;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by root on 17-3-24.
 */
@Repository
public interface TumblrDomainDao {
    List<TumblrDomain> selectAllTumblrDomain();
    List<TumblrDomain> selectTumblrDomainByName(@Param("name")String name);
    List<TumblrDomain> selectTumblrDomainByTag(@Param("tag")String tag);
    void addTumblrDomain(TumblrDomain domain);
    void updateTumblrDomain(TumblrDomain domain);
}
