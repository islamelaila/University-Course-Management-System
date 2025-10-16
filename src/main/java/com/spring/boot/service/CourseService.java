package com.spring.boot.service;

import com.spring.boot.dto.CourseDto;
import com.spring.boot.model.Course;

import java.util.List;

public interface CourseService {

    CourseDto saveCourse(CourseDto courseDto);

    List<CourseDto> getAllCourses();

    CourseDto getCourseById(long id);

}
