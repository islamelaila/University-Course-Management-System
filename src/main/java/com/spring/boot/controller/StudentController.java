package com.spring.boot.controller;

import com.spring.boot.dto.StudentDto;
import com.spring.boot.model.Student;
import com.spring.boot.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("student/save")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<StudentDto> saveStudent(@RequestBody @Valid StudentDto StudentDto) throws URISyntaxException {
        return ResponseEntity.created(new URI("/student/save")).body(studentService.saveStudent(StudentDto));
    }

    @GetMapping("student/all")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<StudentDto>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @GetMapping("student/get/{id}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable long id) {
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    @GetMapping("student/name/{name}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<StudentDto> getStudentByName(@PathVariable String name) {
        return ResponseEntity.ok(studentService.getStudentByName(name));
    }


    @PostMapping("/{studentId}/register/{courseId}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<Student> registerToCourse(
            @PathVariable Long studentId,
            @PathVariable Long courseId) {

        return ResponseEntity.ok(studentService.registerCourseToStudent(studentId, courseId));
    }

    @PostMapping("/by-name/{name}/register/{title}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<Student> registerToCourseByName(
            @PathVariable String name,
            @PathVariable String title) {

        return ResponseEntity.ok(studentService.registerCourseToStudentByName(name, title));
            }
}
