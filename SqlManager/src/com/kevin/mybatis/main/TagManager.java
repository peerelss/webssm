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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        String statement = "com.kevin.mybatis.mapping.tumblrDomainMapper.selectTumblrDomainByLimit";//映射sql的标识字符串
        //执行查询返回一个唯一user对象的sql
        List<TumblrDomain> user = session.selectList(statement);
        for(TumblrDomain tumblrDomain:user){
            addList2Map(getListFromString(tumblrDomain.getTag()));
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
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
                         //Map.entry<Integer,String> 映射项（键-值对）  有几个方法：用上面的名字entry
                         //entry.getKey() ;entry.getValue(); entry.setValue();
            //map.entrySet()  返回此映射中包含的映射关系的 Set视图。
            System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
        }
    }
    public static List<String> getListFromString(String str){
        if(str==null){
            return null;
        }
        List<String> list=new ArrayList<>();
        if(str.contains(",")){
            String[] strings=str.split(",");
            for(int i=0;i<strings.length;i++){
                if(strings[i]!=null&&!"".equals(strings[i])){
                    list.add(strings[i]);
                }
            }
            return list;
        }
        list.add(str);
        return list;
    }
    public static void addList2Map(List<String> list){
        if(list==null||list.size()==0){
            return;
        }else {
            for(String str:list){
                if(str!=null&&!"".equals(str)){
                    map.putIfAbsent(str, 0);
                    map.put(str,map.get(str)+1);
                }

            }
        }
    }
}
