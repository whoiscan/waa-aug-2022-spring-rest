package com.example.phase2.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Student {
    public Student(String firstName, String lastName, String email, String major, String courseTaken, Double gpa, List<Course> courses) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.major = major;
        this.courseTaken = courseTaken;
        this.gpa = gpa;
        this.courses = courses;
    }

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String major;
    private String courseTaken;
    private Double gpa;
    private List<Course> courses;
}
