package com.yjl.mvc.handler;

import com.yjl.mvn.entity.Employee;
import com.yjl.mvn.entity.EmployeeParam;
import com.yjl.mvn.entity.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author yujiale
 */
@Controller
public class Demo04ParamHandler {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/param/one/name/one/value")
    public String oneNameOneValue(
            // 使用@RequestParam注解标记handler方法的形参
            // SpringMVC 会将获取到的请求参数从形参位置给我们传进来
            @RequestParam(value = "userName", defaultValue = "missing") String userName
            // 当请求参数名和形参名一致，可以省略@RequestParam("userName")注解
            // 但是，省略后代码可读性下降而且将来在SpringCloud中不能省略，所以建议还是不要省略
            // String userName
    ) {

        logger.debug("★获取到请求参数：" + userName);

        return "target";
    }

    @RequestMapping("/param/one/name/multi/value")
    public String oneNameMultiValue(

            // 在服务器端 handler 方法中，使用一个能够存储多个数据的容器就能接收一个名字对应的多个值请求参数
            @RequestParam("team") List<String> teamList
            ) {

        for (String team : teamList) {
            logger.debug("team = " + team);
        }

        return "target";
    }

    @RequestMapping("/param/form/to/entity")
    public String formToEntity(

            // SpringMVC 会自动调用实体类中的 setXxx() 注入请求参数
            Employee employee) {

        logger.debug(employee.toString());

        return "target";
    }

    @RequestMapping("/param/form/to/nested/entity")
    public String formToNestedEntity(

            // SpringMVC 自己懂得注入级联属性，只要属性名和对应的getXxx()、setXxx()匹配即可
            Student student) {

        logger.debug(student.toString());

        return "target";
    }

    @RequestMapping("/param/list/emp")
    public String saveEmpList(
            // SpringMVC 访问这里实体类的setEmployeeList()方法注入数据
            EmployeeParam employeeParam
    ) {

        List<Employee> employeeList = employeeParam.getEmployeeList();

        for (Employee employee : employeeList) {
            logger.debug(employee.toString());
        }

        return "target";
    }
}
