package com.yjl.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.yjl.ssm.entity.Emp;
import com.yjl.ssm.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author yujiale
 * @Classname EmpController
 * @Description TOO
 * @Date 2021/10/6 上午11:48
 * @Created by yujiale
 */
@Controller
public class EmpController {
    @Autowired
    private EmpService empService;

    @RequestMapping("/get/all")
    public String getAll(Model model) {

        // 1、查询数据
        List<Emp> empList = empService.getAll();

        // 2.存入模型
        model.addAttribute("empList", empList);

        return "emp-list";
    }

    @RequestMapping("/get/page/{pageIndex}")
    public String getPage(
            @PathVariable("pageIndex")
                    Integer pageIndex,
            Model model
    ) {
        PageInfo<Emp> pageInfo = empService.getPageInfo(pageIndex);
        // 将 PageInfo 对象存入模型
        model.addAttribute("pageInfo", pageInfo);

        return "emp-page";
    }
    @DeleteMapping("/emp/{empId}/{pageNo}")
    public String doRemove(
            @PathVariable("empId") Integer empId,
            @PathVariable("pageNo") Integer pageNo
    ) {

        // 执行删除
        empService.removeEmpById(empId);

        return "redirect:/get/page/" + pageNo;
    }

    @PostMapping("/emp")
    public String saveEmp(Emp emp) {

        // 执行保存
        empService.saveEmp(emp);

        // 为了在保存完成后直接显示新数据，直接前往最后一页
        // 通过 Integer.MAX_VALUE 获取一个非常大的数据，
        // 再结合配置 PageHelper 时指定的 reasonable 就可以直接前往最后一页
        return "redirect:/get/page/" + Integer.MAX_VALUE;
    }

    @GetMapping("/emp/{empId}/{pageNo}")
    public String toEditPage(
            @PathVariable("empId") Integer empId,

            // @PathVariable 注解解析得到的数据会被自动存入模型，
            // 属性名就是注解中的变量名
            @PathVariable("pageNo") Integer pageNo,
            Model model
    ) {

        // 执行查询
      Emp emp = empService.getEmpById(empId);

        // 将实体类对象存入模型
        model.addAttribute("emp", emp);

        return "emp-edit-form";
    }

    @PutMapping("/emp")
    public String updateEmp(Emp emp, @RequestParam("pageNo") Integer pageNo) {

        // 执行更新
        empService.updateEmp(emp);

        // 重定向到分页页面
        return "redirect:/get/page/" + pageNo;
    }
}
