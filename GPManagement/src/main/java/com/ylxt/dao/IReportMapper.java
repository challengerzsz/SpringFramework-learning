package com.ylxt.dao;

import com.ylxt.pojo.MiddleReport;
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
    StartReport checkStartReportValidById(int id);

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
    List<StartReport> getStartReportAuditList(String username);

    @Delete("DELETE FROM start_report_table WHERE id = #{id}")
    void deleteStartReportById(int id);

    @Select("SELECT * FROM start_report_table WHERE number = #{number}")
    StartReport getMyStartReport(String number);

    @Select("SELECT * FROM middle_report_table WHERE number = #{number}")
    @Results({
            @Result(property = "studentName", column = "student_name"),
            @Result(property = "subjectName", column = "subject_name"),
            @Result(property = "subjectId", column = "subject_id"),
            @Result(property = "designArea", column = "design_area"),
            @Result(property = "midConclusion", column = "mid_conclusion"),
            @Result(property = "guideTeacher", column = "guide_teacher")
    })
    MiddleReport getMyMiddleReport(String number);

    @Select("SELECT * FROM middle_report_table WHERE guide_teacher = #{username} AND status = 0")
    @Results({
            @Result(property = "studentName", column = "student_name"),
            @Result(property = "subjectName", column = "subject_name"),
            @Result(property = "subjectId", column = "subject_id"),
            @Result(property = "designArea", column = "design_area"),
            @Result(property = "midConclusion", column = "mid_conclusion"),
            @Result(property = "guideTeacher", column = "guide_teacher")
    })
    List<MiddleReport> getMiddleReportAuditList(String username);

    @Select("SELECT * FROM middle_report_table WHERE id = #{id}")
    @Results({
            @Result(property = "studentName", column = "student_name"),
            @Result(property = "subjectName", column = "subject_name"),
            @Result(property = "subjectId", column = "subject_id"),
            @Result(property = "designArea", column = "design_area"),
            @Result(property = "midConclusion", column = "mid_conclusion"),
            @Result(property = "guideTeacher", column = "guide_teacher")
    })
    MiddleReport checkMiddleReportValidById(int id);

    @Update("UPDATE middle_report_table set status = #{answer} WHERE id = #{id}")
    int confirmMiddleReport(@Param("id") int id,
                            @Param("answer") int answer);

    @Delete("DELETE FROM middle_report_table WHERE id = #{id}")
    void deleteMiddleReportById(int id);

    int submitMiddleReport(MiddleReport middleReport);
}
