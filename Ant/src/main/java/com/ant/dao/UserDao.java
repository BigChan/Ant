package com.ant.dao;

import com.ant.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * Created by doublehuang.
 */

public interface UserDao {
    User getUserByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

    String getUsername(@Param("username") String username);

    void saveUser(@Param("username") String username, @Param("password") String password, @Param("email") String email);
}
