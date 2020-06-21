package com.zhan.gmall.user.controller;

import com.zhan.gmall.user.bean.UserInfo;
import com.zhan.gmall.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/allUsers")
    public List<UserInfo> getAllUsers() {
        List<UserInfo> userInfoList = userService.getUserInfoListAll();
        return userInfoList;
    }

    @GetMapping("/getUser")
    public UserInfo getAllUsers(String id) {
        return userService.getUserById(id);
    }

    @PostMapping("/addUser")
    public String addUser(UserInfo userInfo) {
        userService.addUser(userInfo);
        return "success";
    }

    @PostMapping("/delUser")
    public String delUser(UserInfo userInfo) {
        userService.deleteUser(userInfo);
        return "success";
    }

    @PostMapping("/updateUser")
    public String updateUser(UserInfo userInfo) {
        userService.updateUser(userInfo);
        return "success";
    }

    @PostMapping("/updateUserByName")
    public String updateUserByName(UserInfo userInfo) {
        userService.updateUserByName(userInfo.getName(), userInfo);
        return "success";
    }

}
