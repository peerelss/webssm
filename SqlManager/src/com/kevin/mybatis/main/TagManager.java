package com.kevin.mybatis.main;

import com.kevin.mybatis.model.TumblrDomain;
import com.kevin.mybatis.model.TumblrTag;
import com.kevin.mybatis.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.*;

/**
 * Created by root on 17-3-23.
 */
public class TagManager {
    public static Map<String,Integer> map;
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
        map=new HashMap<>();
        String resource =  "Conf.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        mSqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session=mSqlSessionFactory.openSession();
        String statement = "com.kevin.mybatis.mapping.tumblrTagMapper.batchTumblrTag";//映射sql的标识字符串
        //执行查询返回一个唯一user对象的sql

        /*Map<String,Integer> map=new HashMap<>();
        for(TumblrDomain tumblrDomain:user){
            map.put(tumblrDomain.getTag(),map.get(tumblrDomain.getTag())+1);
        }*/
       /* TumblrDomain tumblrDomain=session.selectOne("com.kevin.mybatis.mapping.tumblrDomainMapper.getTumblrDomain",1);
        tumblrDomain.setLevel(5);
        session.update("com.kevin.mybatis.mapping.tumblrDomainMapper.updateTumblrDomain",tumblrDomain);
        tumblrDomain=session.selectOne("com.kevin.mybatis.mapping.tumblrDomainMapper.getTumblrDomain",1);*/
       /* List<TumblrDomain> user = session.selectList(statement);
        for(TumblrDomain tumblrDomain:user){
            addList2Map(getListFromString(tumblrDomain.getTag()));
        }
        log.info("size  ="+user.size());
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
                         //Map.entry<Integer,String> 映射项（键-值对）  有几个方法：用上面的名字entry
                         //entry.getKey() ;entry.getValue(); entry.setValue();
            //map.entrySet()  返回此映射中包含的映射关系的 Set视图。
            System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
        }*/
        List<TumblrTag> tags=new ArrayList<>();
        tags.add(new TumblrTag("test3",0,new Timestamp(new Date().getTime())));
        tags.add(new TumblrTag("test4",0,new Timestamp(new Date().getTime())));
        session.insert(statement,tags);

    }
    public static List<String> getListFromString(String str){
       return null;
    }
    public static void addList2Map(List<String> list){

    }
}
