package com.spring.boot.controller;
import com.spring.boot.dto.CourseDto;
import com.spring.boot.service.CourseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class CourseController {

    private CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping("course/save")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<CourseDto> saveCourse(@RequestBody @Valid CourseDto courseDto) throws URISyntaxException {
        return ResponseEntity.created(new URI("/course/save")).body(courseService.saveCourse(courseDto));
    }

    @GetMapping ("course/all")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<List<CourseDto>> getAllCourses() {
        return ResponseEntity.ok(courseService.getAllCourses());
    }

    @GetMapping("course/get/{id}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<CourseDto> getCourseById(@PathVariable long id) {
        return ResponseEntity.ok(courseService.getCourseById(id));
    }

}
