package com.bsb.service.impls;

import com.bsb.common.ServerResponse;
import com.bsb.dao.MovieMapper;
import com.bsb.pojo.Movie;
import com.bsb.service.IMoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoviesService implements IMoviesService {

    @Autowired
    private MovieMapper movieMapper;

    @Override
    public ServerResponse<List<Movie>> showMovies() {
        List<Movie> movies = movieMapper.showMovies();
        if (movies == null) {
            return ServerResponse.createByErrorMsg("无影片信息");
        }
        return ServerResponse.createBySuccess("查询所有影片成功",movies);

    }

    @Override
    public ServerResponse<Movie> getMovieInfo(String name) {
        Movie movie = movieMapper.getMovieInfo(name);
        if (movie == null) {
            return ServerResponse.createByErrorMsg("查询的影片不存在");
        }
        return ServerResponse.createBySuccess("查询影片成功", movie);
    }

    @Override
    public ServerResponse<String> addMovie(Movie movie) {
        //todo 校验影片是否存在
        int resultCount = movieMapper.insert(movie);
        if (resultCount == 0) {
            return ServerResponse.createByErrorMsg("添加影片失败");
        }
        return ServerResponse.createBySuccessMsg("添加影片成功");
    }

    @Override
    public ServerResponse<String> checkValid(String name) {
        int resultCount = movieMapper.checkName(name);
        if (resultCount == 0) {
            return ServerResponse.createBySuccess();
        }
        return ServerResponse.createByErrorMsg("影片已存在");
    }
}
