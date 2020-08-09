package com.fu.controller;

import com.fu.biz.UserService;
import com.fu.common.JsonData;
import com.fu.po.Area;
import com.fu.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping
    public JsonData zhuce(User user){
        String zhuce = userService.zhuce(user);
        return JsonData.success(zhuce);
    }

    @GetMapping
    public JsonData login(String name,String password){
        Map map = userService.login(name,password);
        return JsonData.success(map);
    }




}
