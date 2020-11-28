package io.github.vaecebyz.test;

import io.github.vaecebyz.dao.IUserDao;
import io.github.vaecebyz.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class MybatisTest {

    private InputStream in;
    private SqlSession session;
    private IUserDao userDao;

    @Before //测试方法之前执行
    public void init() throws Exception {
        //读取配置文件
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
//创建sessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
//使用工厂生产对象
        session = factory.openSession();
//使用创建代理对象
        userDao = session.getMapper(IUserDao.class);

    }

    @After //测试结束之后执行
    public void destroy() throws Exception {
        //提交事务
        session.commit();
        //释放资源
        session.close();
        in.close();
    }

    //查询所有
    @Test
    public void testFindAll() {

        //使用代理对象执行方法
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }

    }

    //查询一个
    @Test
    public void testFindOne() {

        User user = new User();

        user.setNickname("vaeceby5");

        user = userDao.findOne(user);

        System.out.println(user);

    }
    
    //模糊
    @Test
    public void testFindOneByName() {


        List<User> users = userDao.findOneByName("vae%");

        for (User u : users) {
            System.out.println(u);
        }

    }

    //增加
    @Test
    public void testSave() {
        User user = new User();
        user.setNickname("vaecebyz");
        user.setAvatar("vaecebyz.jpg");
        user.setGender(1);
        user.setAddress("浙江");
        user.setInfo("你好");

        System.out.println(user);

        userDao.saveUser(user);


    }

    //更新
    @Test
    public void testUpdate() {

        User user = new User();
        user.setNickname("vaeceby5");
        user.setAvatar("vaecebyz3.jpg");
        user.setGender(1);
        user.setAddress("浙3江");
        user.setInfo("你好4");
        user.setId(2);

        userDao.updateUser(user);
    }

    //删除
    @Test
    public void testDelUser() {

        User user = new User();

        user.setId(3);

        userDao.delUser(user);
    }
}
