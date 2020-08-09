package com.fu.controller;

import com.fu.biz.UserService;
import com.fu.common.JsonData;
import com.fu.po.Area;
import com.fu.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("usert")
public class User2Controller {

    @Autowired
    private UserService userService;


    @GetMapping
    public JsonData getData(){

        List<User> users = userService.getData();
        return JsonData.success(users);
    }


    //修改密码
    @GetMapping("upd")
    public JsonData upd(Integer id,String password){
        userService.upd(id,password);
        return JsonData.success();
    }
}
