package com.bsb.data;

import java.util.List;


public interface ISpittleRepository {

    //返回的Spittle的最大值,count指需要查询的数量
    List<Spittle> findSpittles(long max, int count);

    Spittle findOne(long id);

    Spittle findByUsername(String username);
}
