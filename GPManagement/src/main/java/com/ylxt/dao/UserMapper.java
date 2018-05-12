package com.ylxt.dao;


import com.ylxt.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface UserMapper {
    @Select("SELECT COUNT(1) FROM user_table WHERE number = #{number} ")
    int checkUserNumber(String number);

    @Select("SELECT * FROM user_table WHERE number = #{number} and password = #{password}")
    User login(@Param("number") String number, @Param("password") String password);

    @Update("UPDATE user_table SET password = #{newPassword} WHERE number = #{number}")
    int resetPassword(@Param("number") String number, @Param("newPassword") String newPassword);
}
