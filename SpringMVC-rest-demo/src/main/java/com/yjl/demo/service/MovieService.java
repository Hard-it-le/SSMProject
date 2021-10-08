package com.yjl.demo.service;


import com.yjl.demo.entity.Movie;

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
