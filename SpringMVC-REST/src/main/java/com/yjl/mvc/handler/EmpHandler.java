package com.yjl.mvc.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author yujiale
 */
@Controller
@RestController("/test")
public class EmpHandler {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 映射请求地址：URL + 请求方式
     *
     * @param message
     * @return
     */
    @RequestMapping(value = "/emp", method = RequestMethod.PUT)
    public String updateEmp(@RequestParam("message") String message) {

        logger.debug("现在执行的是 updateEmp() 方法");
        logger.debug("message = " + message);

        return "target";
    }

    @RequestMapping(value = "/emp", method = RequestMethod.DELETE)
    public String removeEmp() {

        logger.debug("现在执行的是 removeEmp() 方法");

        return "target";
    }

    /**
     * 映射地址：/emp/{empId}是把变量部分用大括号标记出来，写入变量名
     *
     * @param empId
     * @return
     */
    @RequestMapping("/emp/{empId}")
    public String getEmpById(@PathVariable("empId") Integer empId) {

        logger.debug("empId = " + empId);

        return "target";
    }

    @RequestMapping("/emp/{empName}/{empAge}/{empSalary}")
    public String queryEmp(
            @PathVariable("empName") String empName,
            @PathVariable("empAge") Integer empAge,
            @PathVariable("empSalary") Double empSalary
    ) {
        logger.debug("empName = " + empName);
        logger.debug("empAge = " + empAge);
        logger.debug("empSalary = " + empSalary);
        return "target";
    }
}
