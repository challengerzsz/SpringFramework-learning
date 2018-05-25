package com.ylxt.dao;

import com.ylxt.pojo.Subject;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ISubjectMapper {

    @Select("SELECT COUNT(1) FROM subject_table WHERE subject_name = #{subjectName}")
    int checkNameValid(String subjectName);

    int declareSubject(Subject newSubject);

    int publishSubject(Subject newSubject);

    @Select("SELECT * FROM subject_table WHERE guide_teacher = #{username} AND source = 0 AND status = 0")
    @Results({
            @Result(property = "studentName", column = "student_name"),
            @Result(property = "subjectName", column = "subject_name"),
            @Result(property = "topicSource", column = "topic_source"),
            @Result(property = "subjectType", column = "subject_type"),
            @Result(property = "topicType", column = "topic_type"),
            @Result(property = "topicPaper", column = "topic_paper"),
            @Result(property = "guideTeacher", column = "guide_teacher"),
            @Result(property = "attachment", column = "attachment"),
    })
    List<Subject> getAuditList(String username);

    @Select("SELECT * FROM subject_table WHERE id = #{id}")
    @Results({
            @Result(property = "studentName", column = "student_name"),
            @Result(property = "subjectName", column = "subject_name"),
            @Result(property = "topicSource", column = "topic_source"),
            @Result(property = "subjectType", column = "subject_type"),
            @Result(property = "topicType", column = "topic_type"),
            @Result(property = "topicPaper", column = "topic_paper"),
            @Result(property = "guideTeacher", column = "guide_teacher"),
            @Result(property = "attachment", column = "attachment"),
    })
    Subject checkIdValid(int id);

    @Update("UPDATE subject_table SET status = #{answer} WHERE id = #{id}")
    int confirmSubject(@Param("id") int id,
                       @Param("answer") int answer);

    @Select("SELECT COUNT(1) FROM subject_table WHERE number = #{number}")
    int checkNumberValid(String number);

    @Select("SELECT COUNT(1) FROM user_table WHERE username = #{guiderTeacher}")
    int checkTeacherValid(String guideTeacher);

    @Update("UPDATE subject_table set student_name = #{username}, number = #{number}, status = 1 WHERE id = #{id}")
    int selectSubject(@Param("username") String username,
                      @Param("number") String number,
                      @Param("id") int id);

    @Select("SELECT * FROM subject_table WHERE number = #{number} AND source = 0")
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
    Subject checkDeclaredSubject(String number);

    @Select("SELECT * FROM subject_table WHERE number = #{number} AND source = 1")
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
    Subject checkSelectedSubject(String number);


    @Select("SELECT * FROM subject_table WHERE source = 1 AND status = 0")
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
    List<Subject> getUnSelectedSubjects();


    @Select("SELECT * FROM subject_table WHERE guide_teacher = #{username} AND status = 1")
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
    List<Subject> getMyGuideSubject(String username);

    @Select("SELECT * FROM subject_table WHERE number = #{number} AND status = 1")
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
    Subject getMySubject(String number);

    @Delete("DELETE FROM subject_table WHERE id = #{id}")
    void deleteSubject(int id);

    @Select("SELECT * FROM subject_table WHERE guide_teacher = #{username} AND source = 1")
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
    List<Subject> getMyPublishedSubjects(String username);
}
