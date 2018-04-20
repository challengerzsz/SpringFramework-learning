package com.bsb.service;

import com.bsb.common.ServerResponse;
import com.bsb.pojo.Movie;

import java.util.List;

public interface IMoviesService {

    ServerResponse<List<Movie>> showMovies();

    ServerResponse<Movie> getMovieInfo(String name);

    ServerResponse<String> addMovie(Movie movie);

    ServerResponse<String> checkValid(String name);
}
