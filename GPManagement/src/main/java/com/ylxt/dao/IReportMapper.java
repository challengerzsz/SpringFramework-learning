package com.ylxt.dao;

import com.ylxt.pojo.StartReport;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IReportMapper {

    @Select("SELECT * FROM start_report_table WHERE number = #{number}")
    @Results({
            @Result(property = "studentName", column = "student_name"),
            @Result(property = "subjectName", column = "subject_name"),
            @Result(property = "subjectId", column = "subject_id"),
            @Result(property = "guideTeacher", column = "guide_teacher")
    })
    StartReport checkStartReportValid(String number);


    int submitStartReport(StartReport startReport);

    @Select("SELECT * FROM start_report_table WHERE id = #{id}")
    @Results({
            @Result(property = "studentName", column = "student_name"),
            @Result(property = "subjectName", column = "subject_name"),
            @Result(property = "subjectId", column = "subject_id"),
            @Result(property = "guideTeacher", column = "guide_teacher")
    })
    StartReport checkValidById(int id);

    @Update("UPDATE start_report_table set status = #{answer}, opinion = #{opinion} WHERE id = #{id}")
    int confirmStartReport(@Param("id") int id,
                           @Param("answer") int answer,
                           @Param("opinion") String opinion);

    @Select("SELECT * FROM start_report_table WHERE guide_teacher = #{username} AND status = 0")
    @Results({
            @Result(property = "studentName", column = "student_name"),
            @Result(property = "subjectName", column = "subject_name"),
            @Result(property = "subjectId", column = "subject_id"),
            @Result(property = "guideTeacher", column = "guide_teacher")
    })
    List<StartReport> getAuditList(String username);

    @Delete("DELETE FROM start_report_table WHERE id = #{id}")
    void deleteReportById(int id);
}
