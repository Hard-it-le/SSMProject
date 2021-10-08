package com.yjl.mvc.demo.service.api;


import com.yjl.mvc.demo.entity.Movie;

import java.util.List;

/**
 * @author yujiale
 */
public interface MovieService {

    List<Movie> getAll();

    Movie getMovieById(String movieId);

    void saveMovie(Movie movie);

    void updateMovie(Movie movie);

    void removeMovieById(String movieId);

}
