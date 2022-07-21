package com.example.phase2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class StudentDto {
    private String firstName;
    private String lastName;
    private String email;
    private String major;
    private String courseTaken;
    private Double gpa;
    private List<CourseDto> courses;

}