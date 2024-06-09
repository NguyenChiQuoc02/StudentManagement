package com.example.Demo_MVC.rest;

import com.example.Demo_MVC.entity.Course;
import com.example.Demo_MVC.entity.Student;
import com.example.Demo_MVC.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/courses")
public class CourseController {

    private CourseService courseService;
    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/list")
    public String listCourses(Model model){
        List<Course> courses = courseService.getAllCourse();
        model.addAttribute("courses",courses);
        return "course/listCourses";
    }

    @GetMapping("/create")
    public String addCourse(Model model){
        Course course = new Course();
        model.addAttribute("course",course);
        return "course/addCourse";
    }

    @PostMapping("/save")
    public String saveCourse(@ModelAttribute("course") Course course){
         course = courseService.save(course);
         return  "redirect:/courses/list";
    }

    @RequestMapping("update/{id}")
    public String update(@PathVariable("id")  int id, Model model  ){
        Course course = courseService.getCourseById(id);
        model.addAttribute("course",course);
        return "course/updateCourse";
    }

    @GetMapping("/{id}")
    public String getCourseStudents(@PathVariable("id") int id, Model model) {
        Course course = courseService.findCourseById(id);
        if (course != null) {
            model.addAttribute("course", course);
            model.addAttribute("students", course.getStudents());
        }
        return "/course/course_students";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id")  Integer id, Model model  ){
        courseService.deleteById(id);
        return "redirect:/courses/list";
    }

}
