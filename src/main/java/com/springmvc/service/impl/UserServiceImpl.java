package com.springmvc.service.impl;

import com.springmvc.dao.UserDao;
import com.springmvc.dto.User;
import com.springmvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User getUser(String id) {
        return userDao.getUser(id);
    }

    @Override
    public List<User> getAllUser() {
        return userDao.getAllUser();
    }

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public boolean delUser(String id) {

        return userDao.delUser(id);
    }

    @Override
    public boolean updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public boolean login(String username, String password) {
        boolean login = userDao.login(username, password);
        if(login){
            return true;
        }else{
            return false;
        }
    }
}
