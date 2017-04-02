import com.github.pagehelper.PageHelper;
import com.heitian.ssm.dao.TagDao;
import com.heitian.ssm.dao.TumblrDao;
import com.heitian.ssm.dao.TumblrDomainDao;
import com.heitian.ssm.model.Tag;
import com.heitian.ssm.model.TumblrDomain;
import com.heitian.ssm.model.TumblrModel;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 17-3-8.
 */

@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:root.xml"})
public class TestMybatis {
    private static Logger logger=Logger.getLogger(TestMybatis.class);
    @Autowired
    private TagDao mTagDao;
    @Test
    public void test1(){
        /*PageHelper.startPage(2,5);
        List<TumblrDomain> domainList=mTumblrDomainDao.selectAllTumblrDomain();
        for(TumblrDomain domain:domainList){
            logger.info(domain.toString());
        }*/
        List<Tag> tags=new ArrayList<>();
        tags.add(new Tag("test3",0,new Timestamp(new java.util.Date().getTime())));
        tags.add(new Tag("test4",0,new Timestamp(new java.util.Date().getTime())));
        int i=mTagDao.addBatch(tags);
    }
}
