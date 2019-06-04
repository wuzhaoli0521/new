package com.wuzl.mapper;

import com.wuzl.bean.User;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    int creatsUser(@Param("u") User u);
    int deleteUser(@Param("id") int id);
    int updateUser(@Param("u") User u, @Param("id") int id);
    User findbyid(@Param("id") int id);
    List<User> findall(@Param("n")int n,@Param("m")int m);
    int findnum();
}
