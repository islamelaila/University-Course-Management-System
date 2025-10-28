package com.spring.boot.service.impl;
import com.spring.boot.dto.CourseDto;
import com.spring.boot.mapper.CourseMapper;
import com.spring.boot.model.Course;
import com.spring.boot.repo.CourseRepo;
import com.spring.boot.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service

public class CourseServiceImpl implements CourseService {


    private CourseRepo courseRepo;

    private CourseMapper courseMapper;



    @Autowired
    public CourseServiceImpl(CourseRepo courseRepo , CourseMapper courseMapper) {
        this.courseRepo = courseRepo;
        this.courseMapper = courseMapper;
    }

    @Override
    public CourseDto saveCourse(CourseDto courseDto) {
        if (!Objects.nonNull(courseDto.getId())){
            throw new RuntimeException("Can't save course with id, it should be null");
        }

        Course course = courseRepo.save(courseMapper.toEntity(courseDto));
        courseDto.setId(course.getId());
        return courseDto ;
    }

    @Override
    public List<CourseDto> getAllCourses() {
        List<Course> courses = courseRepo.findAll();
        return courses.stream().map(course -> courseMapper.toDto(course)).collect(Collectors.toList());

    }

    @Override
    public CourseDto getCourseById(long id) {
        Course course = courseRepo.findById(id).orElse(null);
        return courseMapper.toDto(course);

    }
}
