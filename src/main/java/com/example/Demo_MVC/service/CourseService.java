package com.example.Demo_MVC.service;

import com.example.Demo_MVC.entity.Course;

import java.util.List;

public interface CourseService {
    public Course save(Course course);
    public List<Course> getAllCourse();
    public Course getCourseById(int id);
    public void deleteById(int id);
    public Course findCourseById(int id);

}
