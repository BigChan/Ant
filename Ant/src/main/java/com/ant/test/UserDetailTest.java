package com.ant.test;

import com.ant.entity.UserDetail;
import com.ant.service.UserDetailService;
import com.ant.web.UserDetailController;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserDetailTest extends BaseTest{

    @Autowired
    private UserDetailService userDetailService;

    private UserDetailController userDetailController;

    @Test
    public void testGetUserDetailById() throws Exception{
        UserDetailController userDetailController = getUserDetailController();
        UserDetail userDetail = userDetailController.getUserDetailById(1);
        if (userDetail==null) {
            System.out.println("找不到数据");
        }else{
            System.out.println(userDetail.getId()+"\t"+userDetail.getName()+"\t"+userDetail.getImage()+"\t"+userDetail.getIntroduction());
        }
    }

    @Test
    public void testSaveUserDetail() throws Exception{
        UserDetailController userDetailController = getUserDetailController();
        String result = userDetailController.saveUserDetail(4,"武松","D://zhaoyun.jpg","武松打虎");
        System.out.println(result);
    }

    @Test
    public void testUpdateUserDetail() throws Exception{
        UserDetailController userDetailController = getUserDetailController();
        String result = userDetailController.updateUserDetail(1,"赵云",null,"常山赵子龙在此");
        System.out.println(result);
    }

    @Test
    public void testDeleteUserDetailById()throws Exception{
        UserDetailController userDetailController = getUserDetailController();
        String result = userDetailController.deleteArticleById(1);
        System.out.println(result);
    }

    private UserDetailController getUserDetailController(){
        if(userDetailController==null){
            userDetailController = new UserDetailController(userDetailService);
        }
        return userDetailController;
    }
}
