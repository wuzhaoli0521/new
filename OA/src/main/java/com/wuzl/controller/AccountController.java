package com.wuzl.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Account")
public class AccountController {

    @RequestMapping("login")
    public void login(String username,String password,String vercode){

        System.out.println(username+" "+password+"  "+vercode);
    }

}
