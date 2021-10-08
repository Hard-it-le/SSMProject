package com.yjl.mvc.demo.handler;


import com.yjl.mvc.demo.entity.Movie;
import com.yjl.mvc.demo.service.api.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author yujiale
 */
@Controller
public class MovieHandler {

    @Autowired
    private MovieService movieService;

    @RequestMapping("/show/list")
    public String showList(Model model) {

        // 1.调用 Service 方法查询数据
        List<Movie> movieList = movieService.getAll();

        // 2.将数据存入模型
        model.addAttribute("movieList", movieList);

        // 3.返回逻辑视图名称
        return "movie-list";
    }

    @RequestMapping("/remove/movie")
    public String removeMovie(
            // 获取请求参数，从形参这里传进来
            @RequestParam("movieId") String movieId,

            Model model
    ) {

        // 1.根据 movieId 执行删除
        movieService.removeMovieById(movieId);

        // 方案一：直接使用列表页面的逻辑视图名称
        // 结果：无法显示数据
        // 原因：没有将列表数据存入模型，所以页面上无法从请求域获取数据来展示
        // return "movie-list";

        // 方案二：我们自己查数据，存入模型，然后返回列表页面的逻辑视图
        // 结果：能够显示数据
        // 建议：不要使用。因为代码重复了。
        // List<Movie> movieList = movieService.getAll();
        // model.addAttribute("movieList", movieList);
        // return "movie-list";

        // 方案三：调用那个返回列表页面的方法
        // 结果：能够显示数据
        // 建议：不要使用。破坏了程序的结构，同时浏览器地址栏显示的还是删除操作的地址，刷新浏览器会重复执行删除操作。
        // return showList(model);

        // 方案四：转发到显示列表页面功能的地址
        // 结果：能够显示数据
        // 建议：不要使用。浏览器地址栏显示的还是删除操作的地址，刷新浏览器会重复执行删除操作。
        // return "forward:/show/list";

        // 方案五：重定向到显示列表页面功能的地址
        // 结果：能够显示数据
        // 建议：建议使用。
        return "redirect:/show/list";
    }

    @RequestMapping("/save/movie")
    public String saveMovie(

            // 表单提交的请求参数会通过实体类的setXx()方法注入
            Movie movie) {

        movieService.saveMovie(movie);

        return "redirect:/show/list";
    }

    @RequestMapping("/edit/movie/page")
    public String editMoviePage(

            // 获取请求参数
            @RequestParam("movieId") String movieId,

            Model model
    ) {

        // 1.根据id查询movie对象
        Movie movie = movieService.getMovieById(movieId);

        // 2.将movie对象存入模型
        model.addAttribute("movie", movie);

        // 3.返回逻辑视图
        return "movie-edit";
    }

    @RequestMapping("/update/movie")
    public String updateMovie(Movie movie) {

        movieService.updateMovie(movie);

        return "redirect:/show/list";
    }

}
