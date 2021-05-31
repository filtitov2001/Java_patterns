package com.lab14.controller;


import com.lab14.data.Student;
import com.lab14.work.StudentWork;
import com.lab14.data.University;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.Map;

@Controller
@RequestMapping("/home")
public class StudentController {
    @Autowired
    private StudentWork studentwork;

    @GetMapping
    public String home(Map<String, Object> data) {
        data.put("universities", studentwork.getAll());
        return "home";
    }

    @PostMapping("/add")
    public String add(
            @RequestParam String stFirstname,
            @RequestParam String stLastname,
            @RequestParam String stMiddlename,
            @RequestParam String stUniname,
            @DateTimeFormat(pattern = "yyyy-MM-dd")
            @RequestParam LocalDate Date,
            Map<String, Object> data
    ) {
        if (stFirstname.isEmpty() || stLastname.isEmpty() || stMiddlename.isEmpty() || stUniname.isEmpty() || Date == null) {
            data.put("universities", studentwork.getAll());
            return "home";
        }
        Student student = new Student();
        student.setFirstName(stFirstname);
        student.setLastName(stLastname);
        student.setMiddleName(stMiddlename);
        University university = new University(stUniname, Date);
        studentwork.save(university, student);
        data.put("universities", studentwork.getAll());
        return "home";
    }

    @PostMapping("/remove")
    public String remove(@RequestParam int studentId, Map<String, Object> data) {
        studentwork.remove(studentId);
        data.put("universities", studentwork.getAll());
        return "home";
    }
}
