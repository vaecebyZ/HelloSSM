package io.github.vaecebyz.test;

import io.github.vaecebyz.dao.IUserDao;
import io.github.vaecebyz.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class MybatisTest {

    public static void main(String[] args) throws Exception {
//读取配置文件
       InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
//创建sessionFactory
       SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
       SqlSessionFactory factory =   builder.build(in);
//使用工厂生产对象
        SqlSession session =  factory.openSession();
//使用创建代理对象
        IUserDao userDao = session.getMapper(IUserDao.class);
//使用代理对象执行方法
        List<User> users = userDao.findAll();
        for (User user : users){
            System.out.println(user);
        }
//释放资源
        session.close();
        in.close();

    }
}
