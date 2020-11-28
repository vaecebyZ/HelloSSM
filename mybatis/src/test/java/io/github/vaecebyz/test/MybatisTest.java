package io.github.vaecebyz.test;
import io.github.vaecebyz.dao.IUserDao;
import io.github.vaecebyz.dao.impl.UserDaoImpl;
import io.github.vaecebyz.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {

    private InputStream in;
    private IUserDao userDao;

    @Before
    public void init() throws Exception {
        //读取配置文件
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建sessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);

        userDao = new UserDaoImpl(factory);
    }

    @Test
    public void testFindAll() {
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
    }

     

    @After
    public void destroy() throws Exception {
        in.close();
    }


}
