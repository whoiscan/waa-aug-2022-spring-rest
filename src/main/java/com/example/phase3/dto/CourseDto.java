package com.example.phase3.dto;

import com.example.phase3.entity.Course;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class CourseDto {
    private int id;
    private String name;
    private int code;

    public Course mapToCourse() {
        return new Course(this.id, this.name, this.code);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
