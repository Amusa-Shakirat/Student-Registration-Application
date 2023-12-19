package com.example.Amusa.studentThymeleaf.controller;


import com.example.Amusa.studentThymeleaf.model.Student;
import com.example.Amusa.studentThymeleaf.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/add-student")
    public ModelAndView saveStudent(){
        ModelAndView modelAndView = new ModelAndView("add-student");
        Student student = new Student();
        modelAndView.addObject("student", student);
        return modelAndView;
    }

    @PostMapping("save-student")
    public ModelAndView saveStudent(@ModelAttribute Student student){
        studentService.saveStudent(student);
        return studentList();
    }

    @GetMapping(value = {"/student-list", "", "home"})
    public ModelAndView studentList(){
        ModelAndView modelAndView = new ModelAndView("student-list");
        List<Student> studentList = studentService.allStudent();
        modelAndView.addObject("students", studentList);
        return modelAndView;
    }

    @GetMapping(value = {"update-student"})
    public ModelAndView updateStudent(@RequestParam Long studentId){
        ModelAndView modelAndView = new ModelAndView("add-student");
        Student student = studentService.getStudentById(studentId);
        modelAndView.addObject("student", student);
        return modelAndView;
    }

    @GetMapping("delete-student")
    public ModelAndView deleteStudent(@RequestParam Long studentId){
        studentService.deleteStudent(studentId);
        return studentList();
    }

}
