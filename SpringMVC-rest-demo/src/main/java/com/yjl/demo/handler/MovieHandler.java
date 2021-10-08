package com.yjl.demo.handler;

import com.yjl.demo.entity.Movie;
import com.yjl.demo.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author yujiale
 */
@Controller
public class MovieHandler {

    @Autowired
    private MovieService movieService;

    @RequestMapping(value = "/movie", method = RequestMethod.GET)
    public String getMovieList(Model model) {

        // 1.调用 Service 方法查询数据
        List<Movie> movieList = movieService.getAll();

        // 2.将数据存入模型
        model.addAttribute("movieList", movieList);

        // 3.返回逻辑视图
        return "movie-list";
    }

    // 实际访问地址举例：/movie/2345QEA
    // 想要把路径中代表 movieId 的部分给匹配出来
    // 所以在 @RequestMapping 注解中写 URL 地址的时候，把地址中动态的部分用大括号标记出来
    // 在大括号中声明变量名
    // 在 @PathVariable 注解中引用这个变量名
    // 使用 @PathVariable 注解修饰一个形参，SpringMVC 就会将匹配到的值从形参这里传入
    @RequestMapping(value = "/movie/{movieId}", method = RequestMethod.DELETE)
    public String removeMovie(
            @PathVariable("movieId") String movieId
    ) {

        // 1.执行删除
        movieService.removeMovieById(movieId);

        // 2.重定向到显示列表的页面
        return "redirect:/movie";
    }

    @RequestMapping(value = "/movie", method = RequestMethod.POST)
    public String saveMovie(Movie movie) {

        movieService.saveMovie(movie);

        return "redirect:/movie";
    }

    @RequestMapping(value ="/movie/{movieId}", method = RequestMethod.GET)
    public String toEditPage(@PathVariable("movieId") String movieId, Model model) {

        Movie movie = movieService.getMovieById(movieId);

        model.addAttribute("movie", movie);

        return "movie-edit";
    }

    @RequestMapping(value = "/movie", method = RequestMethod.PUT)
    public String updateMovie(Movie movie) {

        movieService.updateMovie(movie);

        return "redirect:/movie";
    }
}
