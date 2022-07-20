package com.example.phase1.controller;

import com.example.phase1.service.StudentService;
import com.example.phase1.entity.Course;
import com.example.phase1.entity.Student;
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
    public void create(@RequestBody Student student) {
        studentService.create(student);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> update(@PathVariable Integer id, @RequestBody Student student) {
        return ResponseEntity.ok(studentService.update(id, student));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        studentService.delete(id);
    }
}
