package com.bsb.mapper;

import com.bsb.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    int checkUserName(String username);

    //Mybaits多参数需要使用注解

    User selectLogin(@Param("username") String username, @Param("password") String password);
}
