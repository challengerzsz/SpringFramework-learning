package com.ylxt.dao;

import com.ylxt.pojo.Message;
import org.apache.ibatis.annotations.*;


import java.util.List;

public interface IMessageMapper {

    @Insert("INSERT INTO user_message_table VALUES (null, #{username}, #{targetName}, #{message}, now(), 0)")
    int insert(@Param("username") String username,
               @Param("targetName") String targetName,
               @Param("message") String message);

    @Select("SELECT * FROM user_message_table WHERE targetname = #{targetName} AND status = 0")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "targetName", column = "targetname"),
            @Result(property = "message", column = "message"),
            @Result(property = "timestamp", column = "timestamp"),
            @Result(property = "status", column = "status")
    })
    List<Message> getUnread(String targetName);

    @Update("UPDATE user_message_table SET status = 1 WHERE id = #{id}")
    int read(int id);

    @Select("SELECT * FROM user_message_table WHERE targetname = #{username}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "targetName", column = "targetname"),
            @Result(property = "message", column = "message"),
            @Result(property = "timestamp", column = "timestamp"),
            @Result(property = "status", column = "status")
    })
    List<Message> getInBoxes(String username);

    @Select("SELECT * FROM user_message_table WHERE username = #{username}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "targetName", column = "targetname"),
            @Result(property = "message", column = "message"),
            @Result(property = "timestamp", column = "timestamp"),
            @Result(property = "status", column = "status")
    })
    List<Message> getSendMails(String username);
}
