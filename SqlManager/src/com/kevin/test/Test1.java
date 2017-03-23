
import java.io.IOException;
import java.io.InputStream;

import com.kevin.mybatis.model.TumblrDomain;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by root on 17-3-21.
 */
public class Test1 {
   /* public static void main(String[] args) throws IOException {
        //mybatis的配置文件
        String resource = "Conf.xml";
        //使用类加载器加载mybatis的配置文件（它也加载关联的映射文件）
        InputStream is = Test.class.getClassLoader().getResourceAsStream(resource);
        //构建sqlSession的工厂
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        //使用MyBatis提供的Resources类加载mybatis的配置文件（它也加载关联的映射文件）
        //Reader reader = Resources.getResourceAsReader(resource);
        //构建sqlSession的工厂
        //SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        //创建能执行映射文件中sql的sqlSession
        SqlSession session = sessionFactory.openSession();
        *//**
         * 映射sql的标识字符串，
         * me.gacl.mapping.userMapper是userMapper.xml文件中mapper标签的namespace属性的值，
         * getUser是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
         *//*
        String statement = "com.kevin.mybatis.mapping.userMapper.getUser";//映射sql的标识字符串
        //执行查询返回一个唯一user对象的sql
        User user = session.selectOne(statement, 1);
        System.out.println(user);
        statement = "com.kevin.mybatis.mapping.userMapper.getAllUser";
        List<User> users=session.selectList(statement,"ab");
        for(User user1:users){
            System.out.println(user1);
        }
    }*/
    SqlSessionFactory mSqlSessionFactory;
    Logger log = Logger.getLogger(Test1.class);

    @Before
    public void initFactory() throws IOException{
        String resource =  "Conf.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        mSqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 3. start log
        log.debug("Here is some DEBUG");
        log.info("Here is some INFO");
        log.warn("Here is some WARN");
        log.error("Here is some ERROR");
        log.fatal("Here is some FATAL");
    }
   /* @Test
    public void testQueryOne(){
        SqlSession session=mSqlSessionFactory.openSession();
        String statement = "com.kevin.mybatis.mapping.tumblrTagMapper.getTumblrTag";//映射sql的标识字符串
        //执行查询返回一个唯一user对象的sql
        TumblrTag user = session.selectOne(statement, 1);
        System.out.println(user.toString());
    }
    @Test
    public void testQueryAll(){
        SqlSession session=mSqlSessionFactory.openSession();
        String statement = "com.kevin.mybatis.mapping.tumblrTagMapper.getAllTumblrTag";//映射sql的标识字符串
        //执行查询返回一个唯一user对象的sql
        List<TumblrTag> tags = session.selectList(statement);
        for(TumblrTag tumblrTag:tags){
            System.out.println(tumblrTag);
        }
    }*/
   @Test
   public void testQueryOne(){
       SqlSession session=mSqlSessionFactory.openSession();
       String statement = "com.kevin.mybatis.mapping.tumblrDomainMapper.getTumblrDomain";//映射sql的标识字符串
       //执行查询返回一个唯一user对象的sql
       TumblrDomain user = session.selectOne(statement, 1);
   }
}