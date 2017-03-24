import com.github.pagehelper.PageHelper;
import com.heitian.ssm.dao.TumblrDao;
import com.heitian.ssm.dao.TumblrDomainDao;
import com.heitian.ssm.model.TumblrDomain;
import com.heitian.ssm.model.TumblrModel;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by root on 17-3-8.
 */

@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:root.xml"})
public class TestMybatis {
    private static Logger logger=Logger.getLogger(TestMybatis.class);
    @Autowired
    private TumblrDomainDao mTumblrDomainDao;
    @Test
    public void test1(){
        PageHelper.startPage(2,5);
        List<TumblrDomain> domainList=mTumblrDomainDao.selectAllTumblrDomain();
        for(TumblrDomain domain:domainList){
            logger.info(domain.toString());
        }
    }
}
