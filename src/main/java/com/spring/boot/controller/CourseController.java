package com.spring.boot.controller;
import com.spring.boot.dto.CourseDto;
import com.spring.boot.model.Course;
import com.spring.boot.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    private CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping("course/save")
    public CourseDto saveCourse(@RequestBody CourseDto courseDto) {
        return courseService.saveCourse(courseDto);
    }

    @GetMapping ("course/all")
    public List<CourseDto> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("course/get/{id}")
    public CourseDto getCourseById(@PathVariable long id) {
        return courseService.getCourseById(id);
    }

}
