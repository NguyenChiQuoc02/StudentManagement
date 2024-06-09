package com.example.Demo_MVC.service;

import com.example.Demo_MVC.entity.Student;
import com.example.Demo_MVC.rest.StudentController;

import java.util.List;

public interface StudentService {
    public List<Student> getAllStudents();

    public Student getStudentById(int id);

    public Student addStudent(Student student);



    public void deleteStudentById(int id);

    public List<Student> searchStudent(String name);

}
