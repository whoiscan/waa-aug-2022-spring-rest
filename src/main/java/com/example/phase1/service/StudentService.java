package com.example.phase1.service;

import com.example.phase1.entity.Course;
import com.example.phase1.entity.Student;
import com.example.phase1.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public void create(Student student) {
        studentRepository.save(student);
    }

    public Student getById(int studentId) {
        return studentRepository.findById(studentId);
    }

    public Student update(int studentId, Student student) {
        return studentRepository.update(studentId, student);
    }

    public void delete(int studentId) {
        studentRepository.delete(studentId);
    }


}
