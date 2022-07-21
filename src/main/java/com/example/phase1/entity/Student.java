package com.example.phase1.entity;

import lombok.Data;

import java.util.List;

@Data
public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String major;
    private String courseTaken;
    private Double gpa;
    private List<Course> courses;
}
