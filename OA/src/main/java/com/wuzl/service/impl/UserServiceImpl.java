package com.wuzl.service.impl;

import com.wuzl.bean.User;

import com.wuzl.mapper.UserMapper;
import com.wuzl.service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceImpl implements Userservice {
    @Autowired
    private UserMapper um;

    @Override
    public int creatsUser(User u) {
        int i = um.creatsUser(u);
        return i;
    }

    @Override
    public int deleteUser(int id) {
        int i=um.deleteUser(id);
        return i;
    }

    @Override
    public int updateUser(User u, int id) {
       int i=um.updateUser(u,id);
       return i;
    }

    @Override
    public User findbyid(int id) {
        User u=um.findbyid(id);
        return u;
    }

    @Override
    public List<User> findall(int n, int m) {
        List<User> lu=um.findall(n,m);
        return lu;
    }

    @Override
    public int findnum() {
        return um.findnum();
    }


}
