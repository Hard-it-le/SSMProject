package com.yjl.mvc.handler;

import com.yjl.mvc.entity.Product;
import com.yjl.mvc.entity.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductHandler {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/save/product")
    public String saveProduct(
            Product product,

            // 在实体类参数和 BindingResult 之间不能有任何其他参数
            // 封装数据绑定结果的对象
            BindingResult bindingResult) {

        // 判断数据绑定过程中是否发生了错误
        if (bindingResult.hasErrors()) {
            // 如果发生了错误，则跳转到专门显示错误信息的页面
            // 相关错误信息会自动被放到请求域
            return "error";
        }

        logger.debug(product.toString());

        return "target";
    }

    @RequestMapping("/save/student")
    public String saveStudent(Student student) {

        logger.debug(student.getAddress().toString());

        return "target";
    }
}
