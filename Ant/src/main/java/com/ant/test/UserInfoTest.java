package com.ant.test;

import com.ant.service.UserInfoService;
import com.ant.web.UserInfoController;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserInfoTest extends BaseTest{

    @Autowired
    private UserInfoService userInfoService;

    private UserInfoController userInfoController;

    @Test
    public void testGetUserDetailById() throws Exception{

    }

    @Test
    public void testSaveUserDetail() throws Exception{

    }

    @Test
    public void testUpdateUserDetail() throws Exception{

    }

    @Test
    public void testDeleteUserDetailById()throws Exception{

    }

    private UserInfoController getUserInfoController(){
        if(userInfoController ==null){
            userInfoController = new UserInfoController(userInfoService);
        }
        return userInfoController;
    }
}
