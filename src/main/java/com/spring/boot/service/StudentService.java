package com.spring.boot.service;

import com.spring.boot.dto.StudentDto;
import com.spring.boot.model.Student;

import java.util.List;

public interface StudentService {


   StudentDto saveStudent(StudentDto StudentDto);

   List<StudentDto> getAllStudents();

   StudentDto getStudentById(long id);

   StudentDto getStudentByName(String name);

   Student registerCourseToStudent(long StudentId, long courseId);

   Student registerCourseToStudentByName(String name, String title);


}
