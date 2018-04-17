package com.bsb.dao;

import com.bsb.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    @Select("SELECT count(1) FROM user_table WHERE username = #{username}")
    int checkUserName(String username);

    @Select("select * from user_table where username = #{username} and password = #{password}")
    User selectLogin(@Param("username") String username, @Param("password") String password);

    @Select("select count(1) from user_table where email = #{email}")
    int checkEmail(String email);

    @Select("select question from user_table where username = #{username}")
    String selectQuestionByUsername(String username);

    @Select("select count(1) from user_table where username = #{username} and question = #{question} and answer = #{answer}")
    int checkAnswer(@Param("username") String username, @Param("question") String question, @Param("answer") String answer);

    @Update("update user_table set password = #{passwordNew}, update_time = now() where username = #{username}")
    int updatePasswordByUsername(@Param("username") String username, @Param("password") String passwordNew);

    @Select("select count(1) from user_table where id = #{userId} and password = #{password}")
    int checkPassword(@Param(value = "password") String password, @Param("userId") Integer userId);

    @Select("select count(1) from user_table where email = #{email} and id != #{userId}")
    int checkEmailByUserId(@Param(value="email")String email,@Param(value="userId")Integer userId);
}
