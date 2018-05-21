package com.ylxt.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

public interface FileMapper {

    @Update("UPDATE declaration_subject_table SET attachment = #{saveFilePath} WHERE number = #{number}")
    int insertSaveFilePath(@Param("saveFilePath") String saveFilePath,
                           @Param("number") String number);

}
