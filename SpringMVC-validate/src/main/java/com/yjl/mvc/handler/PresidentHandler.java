package com.yjl.mvc.handler;

import com.yjl.mvc.entity.President;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PresidentHandler {

    Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping("/save/president")
    public String savePresident(

            // 在实体类参数和 BindingResult 之间不能有任何其他参数
            @Validated President president, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "error";
        }

        logger.debug(president.getEmail());

        return "target";
    }

}
