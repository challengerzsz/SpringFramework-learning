package com.ylxt.dao;

import com.ylxt.pojo.Subject;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface SubjectMapper {

    @Select("SELECT COUNT(1) FROM declaration_subject_table WHERE subject_name = #{subjectName}")
    int checkNameValid(String subjectName);


    int declareSubject(Subject newSubject);

    @Select("SELECT * FROM declaration_subject_table WHERE guide_teacher = #{username} AND status = 0")
    @Results({
            @Result(property = "studentName", column = "student_name"),
            @Result(id = true, property = "subjectName", column = "subject_name"),
            @Result(property = "topicSource", column = "topic_source"),
            @Result(property = "subjectType", column = "subject_type"),
            @Result(property = "topicType", column = "topic_type"),
            @Result(property = "topicPaper", column = "topic_paper"),
            @Result(property = "guideTeacher", column = "guide_teacher"),
            @Result(property = "attachment", column = "attachment"),
    })
    List<Subject> getAuditList(String username);

    @Select("SELECT COUNT(1) FROM declaration_subject_table WHERE id = #{id}")
    int checkIdValid(int id);

    @Update("UPDATE declaration_subject_table SET status = #{answer} WHERE id = #{id}")
    int confirmSubject(@Param("id") int id,
                       @Param("answer") int answer);

    @Select("SELECT COUNT(1) FROM declaration_subject_table WHERE number = #{number}")
    int checkNumberValid(String number);

    @Select("SELECT COUNT(1) FROM user_table WHERE username = #{guiderTeacher}")
    int checkTeacherValid(String guideTeacher);

    @Select("SELECT * FROM declaration_subject_table WHERE number = #{number}")
    @Results({
            @Result(property = "studentName", column = "student_name"),
            @Result(id = true, property = "subjectName", column = "subject_name"),
            @Result(property = "topicSource", column = "topic_source"),
            @Result(property = "subjectType", column = "subject_type"),
            @Result(property = "topicType", column = "topic_type"),
            @Result(property = "topicPaper", column = "topic_paper"),
            @Result(property = "guideTeacher", column = "guide_teacher"),
            @Result(property = "attachment", column = "attachment"),
    })
    Subject getDeclareSubject(String number);
}
