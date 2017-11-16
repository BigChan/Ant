package com.ant.web;

import com.ant.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 * Created by doublehuang.
 */

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/login")
    @ResponseBody
    public String login(@RequestParam("username") String username, @RequestParam("password") String password) {
        boolean isCorrect = userService.isUsernameAndPasswordCorrect(username, password);
        if (isCorrect) {
            return "success";
        } else {
            return "fail";
        }
    }

    @RequestMapping("/register")
    @ResponseBody
    public String register(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam(value = "email",required = false) String email) {
        boolean isRegister = userService.registerUser(username, password,email);
        if (isRegister) {
            return "success";
        } else {
            return "fail";
        }
    }


}
