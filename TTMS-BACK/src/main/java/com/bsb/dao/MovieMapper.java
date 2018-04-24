package com.bsb.dao;

import com.bsb.pojo.Movie;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MovieMapper {

    @Select("select * from movie_table limit #{start} , #{end}")
    List<Movie> showMovies(@Param("start") int start, @Param("end") int end);

    @Select("select * from movie_table where name = #{name}")
    Movie getMovieInfo(String name);

    int insert(Movie movie);

    @Select("select count(1) from movie_table where name = #{name}")
    int checkName(String name);

    @Delete("delete from movie_table where name = #{name}")
    int deleteByName(String name);

    int updateMovie(Movie movie);
}
