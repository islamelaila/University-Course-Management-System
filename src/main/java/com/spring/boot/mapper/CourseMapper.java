package com.spring.boot.mapper;
import com.spring.boot.dto.CourseDto;
import com.spring.boot.model.Course;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CourseMapper {

    Course toEntity(CourseDto courseDto);

    CourseDto toDto(Course course);

    List<Course> toEntity(List<CourseDto> courseDtos );

    List<CourseDto> toDto(List<Course> courses);
}
