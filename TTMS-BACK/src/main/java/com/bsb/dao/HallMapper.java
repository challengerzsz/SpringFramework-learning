package com.bsb.dao;

import com.bsb.pojo.Hall;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface HallMapper {

    int insert(Hall hall);

    @Select("select count(1) from hall_table where hall_name = #{hallName}")
    int checkValid(String hallName);

    @Select("select * from hall_table limit #{start}, #{end}")
    List<Hall> showHalls(@Param("start") int start, @Param("end") int end);

    @Delete("delete from hall_table where hall_name = #{hallName}")
    int deleteHallByName(String hallName);

    int updateHall(Hall hall);

    @Select("select * from hall_table where hall_name = #{hallName}")
    Hall getInfoByHallName(String hallName);

}
