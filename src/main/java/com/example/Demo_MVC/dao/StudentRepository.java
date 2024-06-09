package com.example.Demo_MVC.dao;

import com.example.Demo_MVC.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    @Query("SELECT s FROM Student s WHERE s.firstName LIKE %:name% OR s.lastName LIKE %:name%")
    List<Student> searchStudent(String name);
}
