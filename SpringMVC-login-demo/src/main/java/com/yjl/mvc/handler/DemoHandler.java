package com.yjl.mvc.handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoHandler {

    @RequestMapping("/public/resource")
    public String publicResource() {

        return "public-res";
    }

    @RequestMapping("/private/resource/{path}")
    public String privateResource(@PathVariable String path) {

        return "private-"+path;
    }

}
