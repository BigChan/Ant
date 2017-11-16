package com.ant.service.impl;

import com.ant.dao.UserDao;
import com.ant.entity.User;
import com.ant.service.UserService;
import com.ant.util.TextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * Created by doublehuang.
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    public UserDao userDao;

    @Override
    public boolean isUsernameAndPasswordCorrect(String username, String password) {
        User user = userDao.getUserByUsernameAndPassword(username, password);
        return user != null;
    }

    @Override
    public boolean registerUser(String username, String password, String email) {
        if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) return false;
        if (isUserExists(username)) return false;
        userDao.saveUser(username, password, email);
        return true;
    }

    @Override
    public boolean isUserExists(String username) {
        return userDao.getUsername(username) != null;
    }
}
