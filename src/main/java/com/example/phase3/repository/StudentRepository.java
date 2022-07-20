package com.example.phase3.repository;

import com.example.phase3.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class StudentRepository {
    List<Student> students = new ArrayList<>();
    private static int counter = 0;

    public List<Student> findAll() {
        return students;
    }

    public void save(Student student) {
        student.setId(++counter);
        students.add(student);
    }

    public Student update(int studentId, Student student) {
        Student s = findById(studentId);
        int index = students.indexOf(s);
        if (s == null) throw new RuntimeException("Student not found");
        s.setFirstName(student.getFirstName());
        s.setLastName(student.getLastName());
        s.setEmail(student.getEmail());
        s.setMajor(student.getMajor());
        s.setCourseTaken(student.getCourseTaken());
        s.setGpa(student.getGpa());
        s.setCourses(student.getCourses());
        students.set(index, s);
        return s;
    }

    public void delete(int studentId) {
        students.remove(Optional.of(findById(studentId)).orElseThrow(() -> new RuntimeException("Student not found")));
    }

    public Student findById(int studentId) {
        return students.stream().filter(s -> s.getId() == studentId).findFirst().orElseThrow(() -> new RuntimeException("Student not found"));
    }
}
