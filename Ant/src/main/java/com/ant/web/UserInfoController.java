package com.ant.web;

import com.ant.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(produces = "application/json;charset=UTF-8")
public class UserInfoController {

    private UserInfoService userInfoService;

    @Autowired
    public UserInfoController(UserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }

    @RequestMapping("/getUserInfo")
    @ResponseBody
    public String getUserInfo(@RequestParam("username") String username) {
        return userInfoService.getUserInfo(username);
    }

    @RequestMapping("/updateUserInfo")
    @ResponseBody
    public String updateUserInfo(@RequestParam("username")String username,@RequestParam(value = "email",required = false) String email, @RequestParam(value = "sex",required = false) Integer sex, @RequestParam(value = "penname",required = false) String penname, @RequestParam(value = "introduction",required = false) String introduction, @RequestParam(value = "website",required = false) String website) {
        return userInfoService.updateUserInfo(username,email, sex, penname, introduction, website);
    }

}
