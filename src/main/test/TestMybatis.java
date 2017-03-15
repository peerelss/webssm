import com.heitian.ssm.dao.TumblrDao;
import com.heitian.ssm.model.TumblrModel;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by root on 17-3-8.
 */

@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:root.xml"})
public class TestMybatis {
    private static Logger logger=Logger.getLogger(TestMybatis.class);
    @Autowired
    private TumblrDao mTumblrDao;
    @Test
    public void test1(){
        TumblrModel tumblrModel=mTumblrDao.selectTumblrById(1);
        System.out.println(tumblrModel.getName());
    }
}
