package com.ylxt.dao;

import com.ylxt.pojo.Subject;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SubjectMapper {

    @Select("SELECT COUNT(1) FROM declaration_subject_table WHERE subject_name = #{subjectName}")
    int checkNameValid(String subjectName);


    int declareSubject(Subject newSubject);

    @Select("SELECT * FROM declaration_subject_table WHERE guide_teacher = #{username}")
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
}
