package io.github.vaecebyz.dao;

import io.github.vaecebyz.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IUserDao  {

    //查询所有
    //使用注解
    @Select("select * from people")

    List<User> findAll();
}
