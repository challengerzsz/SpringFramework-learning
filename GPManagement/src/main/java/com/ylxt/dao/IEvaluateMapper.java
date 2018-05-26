package com.ylxt.dao;

import com.ylxt.pojo.Evaluate;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface IEvaluateMapper {


    @Select("SELECT * FROM evaluate_table WHERE number = #{number}")
    @Results({
            @Result(property = "studentName", column = "student_name"),
            @Result(property = "subjectName", column = "subject_name"),
            @Result(property = "subjectId", column = "subject_id"),
            @Result(property = "guideTeacher", column = "guide_teacher")
    })
    Evaluate getMyEvaluate(String number);

    int submitEvaluate(Evaluate evaluate);

}
