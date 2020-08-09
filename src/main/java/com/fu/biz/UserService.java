package com.fu.biz;

import com.fu.po.Area;
import com.fu.po.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    String zhuce(User user);

    Map login(String name, String password);


    List<Area> findAreaList();


    void addUser(User user);
    List<User> getData();

    void upd(Integer id,String password);

}
