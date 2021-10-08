package  com.yjl.mvc.demo.test;

import com.yjl.mvc.demo.entity.Movie;
import com.yjl.mvc.demo.service.api.MovieService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;

@SpringJUnitConfig(locations = {"classpath:spring-mvc.xml"})
public class MovieTest {
    
    @Autowired
    private MovieService movieService;
    
    @Test
    public void testServiceGetAll() {
        List<Movie> list = movieService.getAll();
        for (Movie movie : list) {
            System.out.println("movie = " + movie);
        }
    }

    @Test
    public void testServiceGetById() {
        List<Movie> movieList = movieService.getAll();
        for (Movie movie : movieList) {
            String movieId = movie.getMovieId();
            Movie movieById = movieService.getMovieById(movieId);
            System.out.println("movieById = " + movieById);
        }
    }

    @Test
    public void testGetOne() {
        Movie movie = movieService.getMovieById("178E6B0B0DA14DC59141E06FFA620673");
        System.out.println("movie = " + movie);
    }

    @Test
    public void testServiceRemoveById() {
        List<Movie> movieList = movieService.getAll();
        for (Movie movie : movieList) {
            String movieId = movie.getMovieId();
            movieService.removeMovieById(movieId);
        }

        movieList = movieService.getAll();
        for (Movie movie : movieList) {
            System.out.println("movie = " + movie);
        }
    }

    @Test
    public void testServiceSave() {
        movieService.saveMovie(new Movie(null, "aa", 111.11));

        List<Movie> all = movieService.getAll();
        for (Movie movie : all) {
            System.out.println("movie = " + movie);
        }
    }

    @Test
    public void testServiceUpdate() {
        List<Movie> all = movieService.getAll();
        for (Movie movie : all) {
            String movieId = movie.getMovieId();
            String movieName = movie.getMovieName() + "~";

            Movie movieNew = new Movie(movieId, movieName, movie.getMoviePrice());
            movieService.updateMovie(movieNew);
        }

        List<Movie> movieList = movieService.getAll();
        for (Movie movie : movieList) {
            System.out.println("movie = " + movie);
        }
    }
    
}
