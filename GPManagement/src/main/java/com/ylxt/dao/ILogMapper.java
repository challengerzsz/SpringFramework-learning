package com.ylxt.dao;

import com.ylxt.pojo.Log;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ILogMapper {

    @Insert("INSERT INTO log_table VALUES (null, #{publisher}, #{targetName}, #{log}, now())")
    void sendGuideLog(@Param("publisher") String publisher,
                      @Param("targetName") String targetName,
                      @Param("log") String log);

    @Select("SELECT * FROM log_table WHERE targetName = #{username}")
    List<Log> getGuideLogs(String username);

    @Insert("INSERT INTO log_table VALUES (null, #{publisher}, 'all', #{log}, now())")
    int publishLog(Log log);

    @Select("SELECT * FROM log_table WHERE targetName = 'all'")
    List<Log> getPublicLogs();

}
