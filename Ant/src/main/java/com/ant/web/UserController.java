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
@RequestMapping(produces = "application/json;charset=UTF-8")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/login")
    @ResponseBody
    public String login(@RequestParam("username") String username, @RequestParam("password") String password) {
        return userService.loginUser(username, password);
    }

    @RequestMapping(value = "/register")
    @ResponseBody
    public String register(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam(value = "email", required = false) String email) {
        return userService.registerUser(username, password, email);
    }


}
