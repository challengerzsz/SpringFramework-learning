package com.bsb.controller;

import com.bsb.common.ServerResponse;
import com.bsb.pojo.Movie;
import com.bsb.service.IMoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/movies/")
public class MoviesController {

    @Autowired
    private IMoviesService moviesService;

    @RequestMapping(value = "add_movie.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> addMovie(Movie movie) {
        return moviesService.addMovie(movie);
    }

    @RequestMapping(value = "check_valid.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> checkValid(String name) {
        return moviesService.checkValid(name);
    }

    @RequestMapping(value = "show_movies.do", method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse<List<Movie>> showMovies() {
        return moviesService.showMovies();
    }

    @RequestMapping(value = "get_movie_info.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<Movie> getMovieInfo(String name) {
        return moviesService.getMovieInfo(name);
    }
}
