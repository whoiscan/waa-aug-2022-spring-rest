package com.example.phase2.service;

import com.example.phase2.dto.CourseDto;
import com.example.phase2.dto.StudentDto;
import com.example.phase2.entity.Course;
import com.example.phase2.entity.Student;
import com.example.phase2.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    public List<Student> getStudentsByMajor(String major) {
        return Optional.of(studentRepository.findAll().stream().filter(s -> s.getMajor().equals(major)).collect(Collectors.toList())).orElse(Collections.emptyList());
    }

    public List<Course> getCoursesByStudentId(int studentId) {
        return Optional.of(studentRepository.findById(studentId).getCourses()).orElse(Collections.emptyList());
    }

    public void create(StudentDto studentDto) {
        studentRepository.save(mapDtoToStudent(studentDto));
    }

    public Student getById(int studentId) {
        return studentRepository.findById(studentId);
    }

    public Student update(int studentId, StudentDto studentDto) {
        return studentRepository.update(studentId, mapDtoToStudent(studentDto));
    }

    public void delete(int studentId) {
        studentRepository.delete(studentId);
    }

    private Student mapDtoToStudent(StudentDto studentDto) {
        List<Course> courseList = new ArrayList<>();
        for (CourseDto dto : studentDto.getCourses()) {
            courseList.add(mapDtoToCourse(dto));
        }
        return new Student(studentDto.getFirstName(), studentDto.getLastName(), studentDto.getEmail(), studentDto.getMajor(), studentDto.getCourseTaken(), studentDto.getGpa(), courseList);
    }

    private Course mapDtoToCourse(CourseDto courseDto) {
        return new Course(courseDto.getId(), courseDto.getName(), courseDto.getCode());
    }
}
