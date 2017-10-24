package com.ant.test;

import com.ant.entity.User;
import com.ant.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 * Created by doublehuang.
 */

public class UserTest extends BaseTest {

    @Autowired
    private UserService userService;

    @Test
    public void testWhetherUserExists() throws Exception {
        User user = userService.getUserByUsernameAndPassword("ant", "ant");
        assert user != null;
    }

}
