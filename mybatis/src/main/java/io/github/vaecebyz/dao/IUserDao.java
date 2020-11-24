package io.github.vaecebyz.dao;

import io.github.vaecebyz.domain.User;

import java.util.List;

public interface IUserDao  {

    //查询所有
    List<User> findAll();
}
