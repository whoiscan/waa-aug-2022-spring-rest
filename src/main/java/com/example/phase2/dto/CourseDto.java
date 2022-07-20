package com.example.phase2.dto;

import com.example.phase2.entity.Course;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CourseDto {
    private int id;
    private String name;
    private int code;
}
