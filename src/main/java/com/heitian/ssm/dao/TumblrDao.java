package com.heitian.ssm.dao;

import com.heitian.ssm.model.TumblrModel;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by root on 17-3-6.
 */
@Repository
public interface TumblrDao {

    TumblrModel selectTumblrById(@Param("userId") Long userId);

    TumblrModel selectTumblrByPhoneOrEmail(@Param("emailOrPhone") String emailOrPhone, @Param("state") Short state);

    List<TumblrModel> selectAllTumblr();

    long addTumblr(TumblrModel tumblrModel);
    void deleteTumblr(long id);
}
