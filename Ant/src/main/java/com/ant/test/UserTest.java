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
        UserController userController = getUserController();
        String result = userController.login("ant", "ant");
        assert result.equals("success");
    }

    @Test
    public void testRegister() throws Exception {
        UserController userController = getUserController();
        String result = userController.register("edf", "abc","ant@ant.com");
        assert result.equals("success");
    }

    private UserController getUserController(){
        if(userController==null){
            userController = new UserController(userService);
        }
        return userController;
    }

}
