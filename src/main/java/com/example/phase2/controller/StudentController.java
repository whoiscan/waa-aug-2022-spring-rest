package com.example.phase2.controller;

import com.example.phase2.dto.StudentDto;
import com.example.phase2.entity.Course;
import com.example.phase2.entity.Student;
import com.example.phase2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping
    public ResponseEntity<List<Student>> getAll(@RequestParam(value = "major", required = false) String major) {
        return ResponseEntity.ok(ObjectUtils.isEmpty(major) ? studentService.getAll() : studentService.getStudentsByMajor(major));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(studentService.getById(id));
    }

    @GetMapping("/courses/{id}")
    public ResponseEntity<List<Course>> getCoursesByStudent(@PathVariable Integer id) {
        return ResponseEntity.ok(studentService.getCoursesByStudentId(id));
    }

    @PostMapping
    public void create(@RequestBody StudentDto studentDto) {
        studentService.create(studentDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> update(@PathVariable Integer id, @RequestBody StudentDto studentDto) {
        return ResponseEntity.ok(studentService.update(id, studentDto));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        studentService.delete(id);
    }
}
