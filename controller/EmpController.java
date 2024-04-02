package com.kh.jdbc.controller;

import com.kh.jdbc.dao.EmpDao;
import com.kh.jdbc.vo.EmpVo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/emp")
public class EmpController {
    @GetMapping("/select")
    public String selectEmp(Model model) {
        EmpDao dao = new EmpDao();
        List<EmpVo> emps = dao.empSelect();
        model.addAttribute("employees",emps);
        return "thymeleafEx/empSelect";
    }
    @GetMapping("/insert")
    public String insertViewEmp(Model model) {
        model.addAttribute("employees", new EmpVo());
        return "thymeleafEx/empInsert";
    }
    @PostMapping("/insert")
    public String insertDBEmp(@ModelAttribute("employees") EmpVo empVo) {
        EmpDao dao = new EmpDao();
        dao.empInsert(empVo);
        return "thymeleafEx/empInsertRst";
    }
}
