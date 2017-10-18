package com.ant.test;

import com.ant.dao.UserDao;
import com.ant.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 * Created by doublehuang.
 */

public class UserTest extends BaseTest {
    @Autowired
    private UserDao userDao;

    @Test
    public void testWhetherUserExists() throws Exception {
        User user = userDao.getUserByUsernameAndPassword("ant", "a");
        System.out.println(user != null ? "Exists" : "Not Exists");
    }
}
