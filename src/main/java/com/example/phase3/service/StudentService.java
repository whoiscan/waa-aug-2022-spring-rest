package com.example.phase3.service;

import com.example.phase3.dto.CourseDto;
import com.example.phase3.dto.StudentDto;

import java.util.List;

public interface StudentService {
    List<StudentDto> getAll();

    List<StudentDto> getStudentsByMajor(String major);

    List<CourseDto> getCoursesByStudentId(int studentId);

    void create(StudentDto studentDto);

    StudentDto getById(int studentId);

    StudentDto update(int studentId, StudentDto studentDto);

    void delete(int studentId);

}
