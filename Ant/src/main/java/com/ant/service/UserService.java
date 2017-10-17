package com.ant.service;

import com.ant.entity.User;

/**
 * <p>
 * Created by doublehuang.
 */

public interface UserService {
    User getUserByUsernameAndPassword(String username, String password);
}
