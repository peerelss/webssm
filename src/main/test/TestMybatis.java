import com.github.pagehelper.PageHelper;
import com.heitian.ssm.dao.TagDao;
import com.heitian.ssm.dao.TumblrDao;
import com.heitian.ssm.dao.TumblrDomainDao;
import com.heitian.ssm.model.Tag;
import com.heitian.ssm.model.TumblrDomain;
import com.heitian.ssm.model.TumblrModel;
import com.heitian.ssm.utils.TumblrUtil;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by root on 17-3-8.
 */

@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:root.xml"})
public class TestMybatis {
    static   Map<String,Integer> map=new HashMap<>();
    private static Logger logger=Logger.getLogger(TestMybatis.class);
    @Autowired
    private TagDao mTagDao;
    @Autowired
    private TumblrDomainDao mTumblrDomainDao;
    @Test
    public void test1(){
        /*PageHelper.startPage(2,5);
        List<TumblrDomain> domainList=mTumblrDomainDao.selectAllTumblrDomain();
        for(TumblrDomain domain:domainList){
            logger.info(domain.toString());
        }*/
        List<TumblrDomain> tumblrDomainList=mTumblrDomainDao.selectAllTumblrDomain();
       /* for(TumblrDomain tumblrDomain:tumblrDomainList){
            addList2Map(TumblrUtil.getListFromString(tumblrDomain.getTag()));
        }
        List<Tag> tags=new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            //Map.entry<Integer,String> 映射项（键-值对）  有几个方法：用上面的名字entry
            //entry.getKey() ;entry.getValue(); entry.setValue();
            //map.entrySet()  返回此映射中包含的映射关系的 Set视图。
            System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
            tags.add(new Tag(entry.getKey(),entry.getValue(),new Timestamp(new java.util.Date().getTime())));
        }

        int i=mTagDao.addBatch(tags);
        System.out.println("加入 "+i+" 项");*/

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
