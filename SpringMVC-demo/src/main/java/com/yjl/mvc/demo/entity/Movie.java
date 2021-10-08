package com.yjl.mvc.demo.entity;

/**
 * @author yujiale
 */
public class Movie {

    private String movieId;
    private String movieName;
    private Double moviePrice;

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public Double getMoviePrice() {
        return moviePrice;
    }

    public void setMoviePrice(Double moviePrice) {
        this.moviePrice = moviePrice;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieId=" + movieId +
                ", movieName='" + movieName + '\'' +
                ", moviePrice=" + moviePrice +
                '}';
    }

    public Movie(String movieId, String movieName, Double moviePrice) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.moviePrice = moviePrice;
    }

    public Movie() {
    }
}
