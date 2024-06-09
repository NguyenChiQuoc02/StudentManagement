package com.example.Demo_MVC.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "students")
public class Student {
    // fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "last_name", length = 45)
    private String lastName;
    @Column(name = "first_name", length = 45)
    private String firstName;

    @Column(name = "email", length = 45)
    private String email;



    @ManyToMany(fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH
    })
    @JoinTable(
            name="course_student",
            joinColumns = @JoinColumn(name="student_id"),
            inverseJoinColumns = @JoinColumn(name="course_id")
    )
    private List<Course> course;
    // constructor

    public Student() {
    }

    public Student(String lastName, String firstName, String email) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
    }

    public Student(int id, String lastName, String firstName, String email) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
    }

    public Student(String lastName, String firstName, String email, List<Course> course) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.course = course;
    }
// getter,setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Course> getCourse() {
        return course;
    }

    public void setCourse(List<Course> course) {
        this.course = course;
    }
}
