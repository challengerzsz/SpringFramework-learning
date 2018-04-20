package com.bsb.dao;

import com.bsb.pojo.Movie;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MovieMapper {

    @Select("select * from movie_table limit 0,5")
    List<Movie> showMovies();

    @Select("select * from movie_table where name = #{name}")
    Movie getMovieInfo(String name);

    int insert(Movie movie);

    @Select("select count(1) from movie_table where name = #{name}")
    int checkName(String name);
}
