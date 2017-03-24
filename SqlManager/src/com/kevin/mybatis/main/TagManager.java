package com.kevin.mybatis.main;

import com.kevin.mybatis.model.TumblrDomain;
import com.kevin.mybatis.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by root on 17-3-23.
 */
public class TagManager {
    private static TagManager ourInstance = new TagManager();
    public static TagManager getInstance() {
        return ourInstance;
    }
    private TagManager() {
    }
    //从
    public void getTagFromTumblrDomain(){

    }
    public static SqlSessionFactory mSqlSessionFactory;

    private static Logger log = Logger.getLogger(TagManager.class);
    public static void main(String[] args) throws IOException {
        String resource =  "Conf.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        mSqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session=mSqlSessionFactory.openSession();
        String statement = "com.kevin.mybatis.mapping.tumblrDomainMapper.selectTumblrDomainByLimit";//映射sql的标识字符串
        //执行查询返回一个唯一user对象的sql
        List<TumblrDomain> user = session.selectList(statement);
        String TUMBLR_NAME="http://sheersgreat.tumblr.com/";
        for(TumblrDomain tumblrDomain:user){
            String name=tumblrDomain.getName();
            if(!name.contains("tumblr")){
                tumblrDomain.setName(TUMBLR_NAME.replace("sheersgreat",name));
                session.update("com.kevin.mybatis.mapping.tumblrDomainMapper.updateTumblrDomain",tumblrDomain);
            }
            log.info(tumblrDomain.toString());
        }
        log.info("size  ="+user.size());
        /*Map<String,Integer> map=new HashMap<>();
        for(TumblrDomain tumblrDomain:user){
            map.put(tumblrDomain.getTag(),map.get(tumblrDomain.getTag())+1);
        }*/
       /* TumblrDomain tumblrDomain=session.selectOne("com.kevin.mybatis.mapping.tumblrDomainMapper.getTumblrDomain",1);
        tumblrDomain.setLevel(5);
        session.update("com.kevin.mybatis.mapping.tumblrDomainMapper.updateTumblrDomain",tumblrDomain);
        tumblrDomain=session.selectOne("com.kevin.mybatis.mapping.tumblrDomainMapper.getTumblrDomain",1);*/

    }
}
