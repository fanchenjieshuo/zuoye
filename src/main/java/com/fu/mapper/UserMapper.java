package com.fu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fu.po.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseMapper<User> {
        @Select("select * from tuser where name = #{name}")
    User selectByName(String name);

    void upd(@Param("id") Integer id,@Param("password") String password);
}
