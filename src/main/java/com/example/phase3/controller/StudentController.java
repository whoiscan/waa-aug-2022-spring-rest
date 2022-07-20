package com.example.phase3.controller;

import com.example.phase3.dto.CourseDto;
import com.example.phase3.dto.StudentDto;
import com.example.phase3.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600, methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping
    public ResponseEntity<List<StudentDto>> getAll(@RequestParam(value = "major", required = false) String major) {
        return ResponseEntity.ok(ObjectUtils.isEmpty(major) ? studentService.getAll() : studentService.getStudentsByMajor(major));
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(studentService.getById(id));
    }

    @GetMapping("/courses/{id}")
    public ResponseEntity<List<CourseDto>> getCoursesByStudent(@PathVariable Integer id) {
        return ResponseEntity.ok(studentService.getCoursesByStudentId(id));
    }

    @PostMapping
    public void create(@RequestBody StudentDto studentDto) {
        studentService.create(studentDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDto> update(@PathVariable Integer id, @RequestBody StudentDto studentDto) {
        return ResponseEntity.ok(studentService.update(id, studentDto));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        studentService.delete(id);
    }
}
