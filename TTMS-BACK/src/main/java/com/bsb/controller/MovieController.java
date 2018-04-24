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
public class MovieController {

    @Autowired
    private IMoviesService movieService;

    @RequestMapping(value = "add_movie.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> addMovie(Movie movie) {
        return movieService.addMovie(movie);
    }

    @RequestMapping(value = "check_valid.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> checkValid(String name) {
        return movieService.checkValid(name);
    }

    @RequestMapping(value = "show_movies.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<List<Movie>> showMovies(int start, int end) {
        return movieService.showMovies(start, end);
    }

    @RequestMapping(value = "get_movie_info.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<Movie> getMovieInfo(String name) {
        return movieService.getMovieInfo(name);
    }

    @RequestMapping(value = "delete_movie.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> deleteMovieByName(String name) {
        return movieService.deleteMovieByName(name);
    }

    @RequestMapping(value = "update_movie.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> updateMovie(Movie movie) {
        return movieService.updateMovie(movie);
    }
}
