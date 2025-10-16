package com.spring.boot.mapper;
import com.spring.boot.dto.StudentDto;
import com.spring.boot.model.Student;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper {


    Student toEntity(StudentDto studentDTO);

    StudentDto toDto(Student student);

    List<Student> toEntity(List<StudentDto> studentDTOs);

    List<StudentDto> toDto(List<Student> students);
}
