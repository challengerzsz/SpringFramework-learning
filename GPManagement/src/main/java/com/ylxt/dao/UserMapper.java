package com.ylxt.dao;


import com.ylxt.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface UserMapper {
    @Select("SELECT COUNT(1) FROM user_table WHERE number = #{number} ")
    int checkUserNumber(String number);

    @Select("SELECT * FROM user_table WHERE number = #{number} and password = #{password}")
    User login(@Param("number") String number,
               @Param("password") String password);

    @Update("UPDATE user_table SET password = #{newPassword} WHERE number = #{number}")
    int resetPassword(@Param("number") String number,
                      @Param("newPassword") String newPassword);

    @Select("SELECT COUNT(1) FROM user_table WHERE email = #{email}")
    int checkEmail(String email);

    @Select("SELECT COUNT(1) FROM user_table WHERE phone = #{phone}")
    int checkPhone(String phone);

    @Update("UPDATE user_table SET phone = #{phone}, email = #{email}, update_time = now() WHERE number = #{number}")
    int updateUser(@Param("number") String number,
                   @Param("phone") String phone,
                   @Param("email") String email);
}
