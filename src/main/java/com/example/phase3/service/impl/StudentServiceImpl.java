package com.example.phase3.service.impl;

import com.example.phase3.dto.CourseDto;
import com.example.phase3.dto.StudentDto;
import com.example.phase3.entity.Course;
import com.example.phase3.entity.Student;
import com.example.phase3.repository.StudentRepository;
import com.example.phase3.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<StudentDto> getAll() {
        List<Student> students = studentRepository.findAll();
        return mapStudentToDtoList(students);
    }

    @Override
    public List<StudentDto> getStudentsByMajor(String major) {
        List<Student> students = Optional.of(studentRepository.findAll().stream().filter(s -> s.getMajor().equals(major)).collect(Collectors.toList())).orElse(Collections.emptyList());
        return mapStudentToDtoList(students);
    }

    @Override
    public List<CourseDto> getCoursesByStudentId(int studentId) {
        List<Course> courses = Optional.of(studentRepository.findById(studentId).getCourses()).orElse(Collections.emptyList());
        return mapCourseToDtoList(courses);
    }

    @Override
    public void create(StudentDto studentDto) {
        studentRepository.save(mapDtoToStudent(studentDto));
    }

    @Override
    public StudentDto getById(int studentId) {
        return mapStudentToDto(studentRepository.findById(studentId));
    }

    @Override
    public StudentDto update(int studentId, StudentDto studentDto) {
        return mapStudentToDto(studentRepository.update(studentId, mapDtoToStudent(studentDto)));
    }

    @Override
    public void delete(int studentId) {
        studentRepository.delete(studentId);
    }

    private Student mapDtoToStudent(StudentDto studentDto) {
        List<Course> courseList = new ArrayList<>();
        for (CourseDto dto : studentDto.getCourses()) {
            courseList.add(mapDtoToCourse(dto));
        }
        Student student = modelMapper.map(studentDto, Student.class);
        student.setCourses(courseList);
        return student;
    }

    private Course mapDtoToCourse(CourseDto courseDto) {
        return modelMapper.map(courseDto, Course.class);
    }

    private CourseDto mapCourseToDto(Course course) {
        return modelMapper.map(course, CourseDto.class);
    }

    private StudentDto mapStudentToDto(Student student) {
        List<CourseDto> courseDtoList = new ArrayList<>();
        for (Course c : student.getCourses()) {
            courseDtoList.add(mapCourseToDto(c));
        }
        StudentDto studentDto = modelMapper.map(student, StudentDto.class);
        studentDto.setCourses(courseDtoList);
        return studentDto;
    }

    private List<StudentDto> mapStudentToDtoList(List<Student> students) {
        List<StudentDto> result = new ArrayList<>();
        for (Student s : students) {
            result.add(mapStudentToDto(s));
        }
        return result;
    }

    private List<CourseDto> mapCourseToDtoList(List<Course> courses) {
        List<CourseDto> result = new ArrayList<>();
        for (Course s : courses) {
            result.add(mapCourseToDto(s));
        }
        return result;
    }
}
