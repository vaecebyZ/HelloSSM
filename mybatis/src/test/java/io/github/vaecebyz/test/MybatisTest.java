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

    //查询
    @Test
    public void testFindAll() {
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
    }

    //新增
    @Test
    public void testSave() {
        User user = new User();
        user.setInfo("你好2");
        user.setGender(1);
        user.setAddress("地图2");
        user.setNickname("valises");
        user.setAvatar("flakes.jpg");

        userDao.saveUser(user);

        System.out.println(user);
    }

    //更新
    @Test
    public void testUpdate() {

        User user = new User();
        user.setId(4);
        user.setInfo("你好");
        user.setGender(1);
        user.setAddress("地图");
        user.setNickname("valleys");
        user.setAvatar("fakes.jpg");

        userDao.upData(user);
    }

    //删除
    @Test
    public void delUser() {
        User user = new User();
        user.setId(5);
        userDao.delUser(user);
    }


    @After
    public void destroy() throws Exception {

        in.close();
    }


}
