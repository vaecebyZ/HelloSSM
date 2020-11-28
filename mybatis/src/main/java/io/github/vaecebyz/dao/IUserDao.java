package io.github.vaecebyz.dao;

import io.github.vaecebyz.domain.User;


import java.util.List;

public interface IUserDao {

    //查询所有
    //使用注解
    //@Select("select * from people")

    List<User> findAll();

    int saveUser(User user);

    int updateUser(User user);

    int delUser(User user);

    User findOne(User user);

    List<User> findOneByName(String nickname);
}
