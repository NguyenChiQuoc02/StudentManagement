package com.example.Demo_MVC.service;

import com.example.Demo_MVC.dao.CourseRepository;
import com.example.Demo_MVC.entity.Course;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CourseServiceImpl implements CourseService{

    private CourseRepository courseRepository;

    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    @Transactional
    public Course save(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public List<Course> getAllCourse() {
        return courseRepository.findAll() ;
    }

    @Override
    public Course getCourseById(int id) {
        return courseRepository.getById(id);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
       courseRepository.deleteById(id);
    }
    @Override
    public Course findCourseById(int id) {
        return courseRepository.findById(id).orElse(null);
    }

}
