package com.fanzs.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by fzs on 2018/4/19.
 */
@Controller
public class UserController {
    @GetMapping("/user/login")
    public String loginPage(){
        return "user/login";
    }

    @GetMapping("/user/center")
    public String userCenterPage(){
        return "user/center";
    }

    @GetMapping("/user/logout")
    public String logoutPage(){
        return "logout";
    }
}
