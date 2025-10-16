package com.spring.boot.controller;

import com.spring.boot.dto.StudentDto;
import com.spring.boot.model.Student;
import com.spring.boot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("student/save")
    public StudentDto saveStudent(@RequestBody StudentDto StudentDto) {
        return studentService.saveStudent(StudentDto);
    }

    @GetMapping("student/all")
    public List<StudentDto> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("student/get/{id}")
    public StudentDto getStudentById(@PathVariable long id) {
        return studentService.getStudentById(id);
    }

    @GetMapping("student/name/{name}")
    public StudentDto getStudentByName(@PathVariable String name) {
        return studentService.getStudentByName(name);
    }


    @PostMapping("/{studentId}/register/{courseId}")
    public Student registerToCourse(
            @PathVariable Long studentId,
            @PathVariable Long courseId) {

        return studentService.registerCourseToStudent(studentId, courseId);
    }

    @PostMapping("/by-name/{name}/register/{title}")
    public Student registerToCourseByName(
            @PathVariable String name,
            @PathVariable String title) {

        return studentService.registerCourseToStudentByName(name, title);
            }
}
