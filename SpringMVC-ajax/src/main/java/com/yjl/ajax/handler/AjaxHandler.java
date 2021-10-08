package com.yjl.ajax.handler;


import com.yjl.ajax.entity.Soldier;
import com.yjl.ajax.entity.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author yujiale
 */
@RestController
public class AjaxHandler {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    // 使用@ResponseBody注解告诉 SpringMVC：请你拿当前方法的返回值作为响应体，不要再找视图了
    // 方法返回值类型有两种情况：
    // 情况一：简单类型。SpringMVC 会直接作为响应体数据。
    // 情况二：复杂类型。SpringMVC 会把它转换为 JSON 然后再作为响应体。此时需要 Jackson 的支持。
    // @ResponseBody
    @RequestMapping("/ajax/experiment/one.html")
    public String experimentOne(

            // Ajax请求发过来的请求参数，对服务器端来说没有区别，还是像以前一样正常接收
            @RequestParam("userName") String userName,
            @RequestParam("password") String password
    ) {

        logger.debug("userName = " + userName);
        logger.debug("password = " + password);

        // 服务器端给Ajax程序的响应数据通过handler方法的返回值提供
        return "message from handler as response[来自服务器的问候]";
    }

    // @ResponseBody
    @RequestMapping("/ajax/experiment/two.html")
    public String experimentTwo(

            // 使用 @RequestBody 注解将请求体 JSON 数据解析出来，注入到对应的实体类中
            @RequestBody Student student
            ) {

        logger.debug(student.toString());

        return "message from handler as response[来自服务器的问候]";
    }

    // @ResponseBody
    @RequestMapping("/ajax/experimentThree.html")
    public String experimentThree(

            // 请求参数名正好对这个实体类的属性名，可以通过 setXxx() 方法直接注入
            Soldier soldier) {

        logger.debug(soldier.toString());

        return "message from handler as response[来自服务器的问候]";
    }

    // 使用 @ResponseBody 注解标记的方法返回实体类数据时，
    // SpringMVC 需要借助 Jackson 来将实体类转换为 JSON 数据
    // @ResponseBody
    @RequestMapping("/ajax/experimentFour.json")
    public Soldier experimentFour() {

        return new Soldier(333, "catMan");
    }
}
