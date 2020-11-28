package io.github.vaecebyz.dao.impl;

import io.github.vaecebyz.dao.IUserDao;
import io.github.vaecebyz.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class UserDaoImpl implements IUserDao {

    private SqlSessionFactory factory;

    //构造
    public UserDaoImpl(SqlSessionFactory factory) {
        this.factory = factory;
    }

    //实现方法
    public List<User> findAll() {
        //使用工厂
        SqlSession session = factory.openSession();
        List<User> users = session.selectList("io.github.vaecebyz.dao.IUserDao.findAll");//需要找到配置
        session.close();
        return users;
    }

    public void upData(User user) {
        //使用工厂
        SqlSession session = factory.openSession();
        session.update("io.github.vaecebyz.dao.IUserDao.upData", user);
        session.commit();
        session.close();
    }

    public void saveUser(User user) {
        //使用工厂
        SqlSession session = factory.openSession();
        session.insert("io.github.vaecebyz.dao.IUserDao.saveUser", user);
        session.commit();
        session.close();
    }

    public void delUser(User u) {
        //使用工厂
        SqlSession session = factory.openSession();
        session.delete("io.github.vaecebyz.dao.IUserDao.delUser", u);
        session.commit();
        session.close();
    }
}
