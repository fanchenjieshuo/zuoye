package com.fu.biz.impl;

import com.fu.biz.UserService;
import com.fu.mapper.AreaMapper;
import com.fu.mapper.UserMapper;
import com.fu.po.Area;
import com.fu.po.User;
import com.fu.utils.JWT;
import com.fu.utils.RedisUse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private AreaMapper areaMapper;


    @Override
    public String zhuce(User user) {
        User user1 = userMapper.selectByName(user.getName());
        if (user1 == null){

            User user2 = new User();
            user2.setRegisterdate(new Date());
            user.setRegisterdate(new Date());
            userMapper.insert(user);
            return "注册成功";
        }else {
            return "该账户已存在";
        }

    }

    @Override
    public Map login(String name, String password) {
        Map map = new HashMap();
        User user = userMapper.selectByName(name);
        if (password != null && password.equals(user.getPassword())){
            Map user1 = new HashMap();
            user1.put("name",name);

            //生成秘钥
            String sign = JWT.sign(user, 60 * 60 * 24 * 1000);
            //加签，手机号+sign 防止数据被篡改
            String token = Base64.getEncoder().encodeToString((name + "," + sign).getBytes());
            //将秘钥放入redis，保证只有最新的能使用
            RedisUse.set("token_"+name,sign,60*60*24);

            map.put("status",200);
            map.put("message","登录成功");
            map.put("token",token);
        }else {
            map.put("status",500);
            map.put("message","密码错误");
        }
        return map;
    }

    @Override
    public List<Area> findAreaList() {


        List<Area> areas = areaMapper.selectList(null);

        return areas;
    }

    @Override
    public void addUser(User user) {


    user.setRegisterdate(new Date());

        userMapper.insert(user);
    }

    @Override
    public List<User> getData() {



        return userMapper.selectList(null);
    }

    @Override
    public void upd(Integer id,String password) {
        userMapper.upd(id,password);
    }
}
