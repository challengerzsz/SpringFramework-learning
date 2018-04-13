package com.bsb.dao;

import com.bsb.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    @Select("SELECT count(1) FROM user_table WHERE username = #{username}")
    int checkUserName(String username);

    @Select("select * from user_table where username = #{username} and password = #{password}")
    User selectLogin(@Param("username") String username, @Param("password") String password);
}
