package com.bsb.dao;

import com.bsb.pojo.Hall;
import org.apache.ibatis.annotations.Select;

public interface HallMapper {
    int insert(Hall hall);

    @Select("select count(1) from hall_table where hall_name = #{hallName}")
    int checkValid(String hallName);
}
