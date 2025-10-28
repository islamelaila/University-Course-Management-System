package com.spring.boot.service.impl;
import com.spring.boot.dto.StudentDto;
import com.spring.boot.mapper.StudentMapper;
import com.spring.boot.model.Course;
import com.spring.boot.model.Student;
import com.spring.boot.repo.CourseRepo;
import com.spring.boot.repo.StudentRepo;
import com.spring.boot.service.StudentService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {


    private StudentRepo studentRepo;

    private CourseRepo courseRepo;
    private StudentMapper studentMapper;

    @Autowired
    public StudentServiceImpl(StudentRepo studentRepo , CourseRepo courseRepo , StudentMapper studentMapper ) {
        this.studentRepo = studentRepo;
        this.courseRepo = courseRepo;
        this.studentMapper = studentMapper;
    }

    @Override
    public StudentDto saveStudent(StudentDto StudentDto) {
        List<Course> actualCourses = new ArrayList<>();

        if (StudentDto.getCourses() != null) {
            for (Course c : StudentDto.getCourses()) {
                Course course = courseRepo.findById(c.getId())
                        .orElseThrow(() -> new RuntimeException("Course not found"));
                actualCourses.add(course);
            }
        }

        StudentDto.setCourses(actualCourses);

        Student student = studentRepo.save(studentMapper.toEntity(StudentDto));
        StudentDto.setId(student.getId());


        return StudentDto ;
    }


    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> students = studentRepo.findAll();
        return students.stream().map(student -> studentMapper.toDto(student)).collect(Collectors.toList());
    }

    @Override
    public StudentDto getStudentById(long id) {
        Student student = studentRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        return studentMapper.toDto(student);
    }

    @Override
    public StudentDto getStudentByName(String name) {
        if(studentRepo.findByName(name) == null){
            throw new RuntimeException("Student not found");
        }
        Student student = studentRepo.findByName(name);
        return studentMapper.toDto(student);
    }

    @Override
    @Transactional
    public Student registerCourseToStudent(long StudentId, long courseId) {
        Student student = studentRepo.findById(StudentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        Course course = courseRepo.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        if (student != null && course != null) {
            student.getCourses().add(course);
            course.getStudents().add(student);
            studentRepo.save(student);
        }
        return student;
    }

    @Override
    public Student registerCourseToStudentByName(String name, String title) {
        Student student = studentRepo.findByName(name);
        Course course = courseRepo.findCourseByTitle(title);

        if (student != null && course != null) {
            student.getCourses().add(course);
            course.getStudents().add(student);
            studentRepo.save(student);
        }
        return student;
    }
}
