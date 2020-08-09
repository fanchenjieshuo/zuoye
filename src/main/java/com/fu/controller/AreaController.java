package com.fu.controller;

import com.fu.biz.UserService;
import com.fu.common.JsonData;
import com.fu.po.Area;
import com.fu.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("area")
public class AreaController {

    @Autowired
    private UserService userService;



    @RequestMapping("findAreaList")
    public Map findAreaList(){
        HashMap<Object, Object> result = new HashMap<>();
       try {
           List<Area> areaList = userService.findAreaList();
           result.put("data",areaList);
           result.put("code",200);
       }catch (Exception e){
           result.put("code",500);

       }

        return  result;
    }


    @RequestMapping("zhuce")
    public Map zhuce(User user){
        HashMap<Object, Object> result = new HashMap<>();


        try {
          userService.addUser(user);

            result.put("data","注册成功");
            result.put("code",200);
        } catch (Exception e){

            result.put("code",500);
    }

        return result;
    }

}
