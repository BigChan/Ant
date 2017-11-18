package com.ant.service.impl;

import com.ant.dao.UserDao;
import com.ant.entity.User;
import com.ant.service.UserService;
import com.ant.util.JsonUtils;
import com.ant.util.TextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * Created by doublehuang.
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    public UserDao userDao;

    @Override
    public String loginUser(String username, String password) {
        User user = userDao.getUserByUsernameAndPassword(username, password);
        Map<String, Object> map = new HashMap<>();
        if (user != null) {
            map.put("code", 1);
            map.put("message", "登录成功");
        } else {
            map.put("code", 0);
            map.put("message", "账号或密码不正确");
        }
        return JsonUtils.toJsonString(map);
    }

    @Override
    public String registerUser(String username, String password, String email) {
        Map<String, Object> map = new HashMap<>();
        if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password) || isUserExists(username)) {
            map.put("code", 0);
            map.put("message", "账号已存在");
        } else {
            userDao.saveUser(username, password, email);
            map.put("code", 1);
            map.put("message", "注册成功");
        }
        return JsonUtils.toJsonString(map);
    }

    @Override
    public boolean isUserExists(String username) {
        return userDao.getUsername(username) != null;
    }
}
