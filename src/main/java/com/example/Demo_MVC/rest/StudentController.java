package com.example.Demo_MVC.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.Demo_MVC.entity.Student;
import com.example.Demo_MVC.service.StudentService;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {
    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/list")
    public String listAll(Model model){
        List<Student> students = studentService.getAllStudents();
        model.addAttribute("students", students);
        return "student/students";
    }

    @GetMapping("/create")
    public String create(Model model){
        Student student = new Student();
        model.addAttribute("student",student);
        return "student/addStudent";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("student")  Student student){
        studentService.addStudent(student);
        return "redirect:/students/list";
    }

    @RequestMapping("update/{id}")
    public String update(@PathVariable("id")  int id, Model model  ){
        Student student = studentService.getStudentById(id);
        model.addAttribute("student",student);
        return "student/updateStudent";
    }



    @GetMapping("/delete")
    public String delete(@RequestParam("id")  Integer id, Model model  ){
        studentService.deleteStudentById(id);
        return "redirect:/students/list";
    }

    @GetMapping("/search")
    public String search(@RequestParam("name" ) String name, Model model){
        List<Student> students = studentService.searchStudent(name);
        model.addAttribute("students",students);
        return "student/search";
    }
}
