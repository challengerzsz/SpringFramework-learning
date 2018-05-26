package com.ylxt.dao;

import com.ylxt.pojo.Paper;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IPaperMapper {

    @Select("SELECT * FROM paper_table WHERE number = #{number}")
    @Results({
            @Result(property = "studentName", column = "student_name"),
            @Result(property = "subjectName", column = "subject_name"),
            @Result(property = "subjectId", column = "subject_id"),
            @Result(property = "guideTeacher", column = "guide_teacher")
    })
    Paper getMyPaper(String number);

    int submitPaper(Paper paper);

    @Select("SELECT * FROM paper_table WHERE guide_teacher = #{username} AND status = 0")
    @Results({
            @Result(property = "studentName", column = "student_name"),
            @Result(property = "subjectName", column = "subject_name"),
            @Result(property = "subjectId", column = "subject_id"),
            @Result(property = "guideTeacher", column = "guide_teacher")
    })
    List<Paper> refreshPaperAuditList(String username);

    @Select("SELECT * FROM paper_table WHERE id = #{id}")
    @Results({
            @Result(property = "studentName", column = "student_name"),
            @Result(property = "subjectName", column = "subject_name"),
            @Result(property = "subjectId", column = "subject_id"),
            @Result(property = "guideTeacher", column = "guide_teacher")
    })
    Paper checkValidById(int id);

    @Update("UPDATE paper_table SET status = #{answer}, score = #{score} WHERE id = #{id}")
    int confirmPaper(@Param("id") int id,
                     @Param("answer") int answer,
                     @Param("score") int score);

    @Delete("DELETE FROM paper_table WHERE id = #{id}")
    void deletePaper(int id);

    @Select("SELECT * FROM paper_table WHERE number = #{number} AND status = 1")
    @Results({
            @Result(property = "studentName", column = "student_name"),
            @Result(property = "subjectName", column = "subject_name"),
            @Result(property = "subjectId", column = "subject_id"),
            @Result(property = "guideTeacher", column = "guide_teacher")
    })
    Paper getResult(String number);
}
