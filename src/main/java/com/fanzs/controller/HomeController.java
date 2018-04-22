package com.fanzs.controller;

import com.fanzs.base.APIResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by fzs on 2018/4/18.
 */
@ Controller
public class HomeController {
    @GetMapping(value = {"/","/index"})
    public String index(Model model){
        model.addAttribute("name","fanzs");
        return "index";
    }

    @GetMapping("/404")
    public String get(){
        return "404";
    }
}
