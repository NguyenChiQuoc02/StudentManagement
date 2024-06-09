package com.example.Demo_MVC.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name_course", length = 45)
    private String nameCourse;

    @Column(name= "number_of_students")
    private int numberOfStudents;

    @Column(name="number_of_credits")
    private int numberOfCredits;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH
    })
    @JoinTable(
            name="course_student",
            joinColumns = @JoinColumn(name="course_id"),
            inverseJoinColumns = @JoinColumn(name="student_id")
    )
    private List<Student> students;

    public Course(String nameCourse, int numberOfStudents, int numberOfCredits, List<Student> students) {
        this.nameCourse = nameCourse;
        this.numberOfStudents = numberOfStudents;
        this.numberOfCredits = numberOfCredits;
        this.students = students;
    }

    public Course(){}

    public Course(int id, String nameCourse, int numberOfStudents, int numberOfCredits) {
        this.id = id;
        this.nameCourse = nameCourse;
        this.numberOfStudents = numberOfStudents;
        this.numberOfCredits = numberOfCredits;
    }

    public Course(String nameCourse, int numberOfStudents, int numberOfCredits) {
        this.nameCourse = nameCourse;
        this.numberOfStudents = numberOfStudents;
        this.numberOfCredits = numberOfCredits;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameCourse() {
        return nameCourse;
    }

    public void setNameCourse(String nameCourse) {
        this.nameCourse = nameCourse;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public void setNumberOfStudents(int numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
    }

    public int getNumberOfCredits() {
        return numberOfCredits;
    }

    public void setNumberOfCredits(int numberOfCredits) {
        this.numberOfCredits = numberOfCredits;
    }
    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
