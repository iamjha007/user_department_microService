package com.springLearn.userService.controller;

import com.springLearn.userService.Vo.ResponseTemplateVo;
import com.springLearn.userService.entity.User;
import com.springLearn.userService.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
@Slf4j
public class UserController{

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User saveUser(@RequestBody User user){

        return userService.saveUser(user);
    }
    @GetMapping("/{id}")
    public User findUserById(@PathVariable("id") Long userId){
        return userService.getUserById(userId);
    }

    @GetMapping("/getuserdepartment/{id}")
    public ResponseTemplateVo findUserWithDeparment(@PathVariable("id") Long userid){

        return userService.findUserWithDepartment(userid);
    }
}
