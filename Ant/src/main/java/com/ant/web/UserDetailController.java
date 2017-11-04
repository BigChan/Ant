package com.ant.web;

import com.ant.entity.UserDetail;
import com.ant.service.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserDetailController {

    private  UserDetailService userDetailService;

    @Autowired
    public UserDetailController(UserDetailService userDetailService){
        this.userDetailService = userDetailService;
    }

    @RequestMapping("/getUserDetailById")
    public UserDetail getUserDetailById(@RequestParam("id") int id) {
        UserDetail userDetail = userDetailService.getUserDetailById(id);
        return userDetail;
    }

    @RequestMapping("/saveUserDetail")
    @ResponseBody
    public String saveUserDetail(@RequestParam("id")int id,@RequestParam("name") String name,
                                 @RequestParam("image") String image, @RequestParam("introduction") String introduction) {
        boolean isTrue = userDetailService.saveUserDetail(id,name,image,introduction);
        String returnString = "插入失败";
        if(isTrue){returnString = "插入成功";}
        return returnString;
    }

    @RequestMapping("/deleteUserDetailById")
    @ResponseBody
    public String deleteArticleById(@RequestParam("id") int id){
        boolean isTrue = userDetailService.deleteUserDetailById(id);
        String returnString = "删除失败";
        if(isTrue){returnString = "删除成功";}
        return returnString;
    }

    @RequestMapping("/updateUserDetail")
    @ResponseBody
    public String updateUserDetail(@RequestParam("id") int id,@RequestParam("name") String name,
                                   @RequestParam("image") String image, @RequestParam("introduction") String introduction){
        boolean isTrue = userDetailService.updateUserDetail(id,name,image,introduction);
        String returnString = "更新失败";
        if(isTrue){
            returnString = "更新成功";
        }
        return returnString;
    }
}
