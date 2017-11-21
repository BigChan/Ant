package com.ant.test;

import com.ant.service.UserService;
import com.ant.web.UserController;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 * Created by doublehuang.
 */

public class UserTest extends BaseTest {

    @Autowired
    private UserService userService;

    private UserController userController;

    @Test
    public void testLogin() throws Exception {

    }

    @Test
    public void testRegister() throws Exception {

    }

    private UserController getUserController(){
        if(userController==null){
            userController = new UserController(userService);
        }
        return userController;
    }

}
