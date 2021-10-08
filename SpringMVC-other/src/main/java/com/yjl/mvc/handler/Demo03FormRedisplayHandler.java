package com.yjl.mvc.handler;

import com.yjl.mvc.demo.John;
import com.yjl.mvc.demo.Paige;
import com.yjl.mvc.demo.Season;
import com.yjl.mvc.demo.Tiger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class Demo03FormRedisplayHandler {

    @RequestMapping("/form/redisplay/simple")
    public String simpleTagRedisplay(Model model) {

        // 1.准备好用来回显表单的实体类对象
        // 在实际功能中，这里的对象应该是从数据库查询得到
        Tiger tiger = new Tiger();
        tiger.setTigerId(5);
        tiger.setTigerName("tomCat");
        tiger.setTigerSalary(666.66);

        // 2.将实体类数据存入模型
        model.addAttribute("tiger", tiger);

        return "form-simple";
    }

    @RequestMapping("/form/redisplay/choose")
    public String chooseTagRedisplay(Model model) {

        // 1.准备用来显示标签的数据
        List<Season> seasonList = new ArrayList<>();
        seasonList.add(new Season("spring", "春天"));
        seasonList.add(new Season("summer", "夏天"));
        seasonList.add(new Season("autumn", "秋天"));
        seasonList.add(new Season("winter", "冬天"));

        model.addAttribute("seasonList", seasonList);

        // 2.准备用来回显表单的实体类数据
        Paige paige = new Paige();
        paige.setPaigeId(6);
        paige.setPaigeName("pig");
        paige.setSeason(new Season("summer", "夏天"));

        model.addAttribute("paige", paige);

        return "form-choose";
    }

    @RequestMapping("/form/redisplay/choose/multi")
    public String chooseMulti(Model model) {

        // 1.准备用来显示标签的数据
        List<Season> seasonList = new ArrayList<>();
        seasonList.add(new Season("spring", "春天"));
        seasonList.add(new Season("summer", "夏天"));
        seasonList.add(new Season("autumn", "秋天"));
        seasonList.add(new Season("winter", "冬天"));

        model.addAttribute("seasonList", seasonList);

        // 2.准备用来回显表单的实体类数据
        John john = new John();
        List<Season> seasonListForRedisplay = new ArrayList<>();
        seasonListForRedisplay.add(new Season("summer", "夏天"));
        seasonListForRedisplay.add(new Season("winter", "冬天"));

        model.addAttribute("seasonListForRedisplay", seasonListForRedisplay);

        return "form-multi";
    }

}
