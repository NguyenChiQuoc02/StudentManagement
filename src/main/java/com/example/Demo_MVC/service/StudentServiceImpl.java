package com.example.Demo_MVC.service;


import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Demo_MVC.dao.StudentRepository;
import com.example.Demo_MVC.entity.Student;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{
    private StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(int id) {
        return studentRepository.getById(id);
    }

    @Override
    @Transactional
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    @Transactional
    public void deleteStudentById(int id) {
        studentRepository.deleteById(id);
    }

    @Override
    public List<Student> searchStudent(String name) {
        return studentRepository.searchStudent(name);
    }
}
