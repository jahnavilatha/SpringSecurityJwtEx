package com.security.SpringSecurityExample.controller;


import com.security.SpringSecurityExample.model.Users;
import com.security.SpringSecurityExample.service.JwtService;
import com.security.SpringSecurityExample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;



    @PostMapping("/register")
    public Users register(@RequestBody Users user){
        return userService.register(user);
    }
    @PostMapping("/login")
    public String login(@RequestBody Users user){
        return userService.verify(user);
//        System.out.println(user);
//        return "Success";
    }
}