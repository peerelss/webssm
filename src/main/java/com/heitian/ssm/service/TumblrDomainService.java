package com.heitian.ssm.service;

import com.heitian.ssm.model.TumblrDomain;

import java.util.List;

/**
 * Created by root on 17-3-24.
 */
public interface TumblrDomainService {
    List<TumblrDomain> selectAllTumblrDomain();
    List<TumblrDomain> selectTumblrListByName(String name);
    void addTumblrDomain(TumblrDomain domain);
}

