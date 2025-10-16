package com.spring.boot.mapper;

import com.spring.boot.dto.InstructorDto;
import com.spring.boot.model.Instructor;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InstructorMapper {

   Instructor toEntity(InstructorDto instructorDTO);

   InstructorDto toDto(Instructor instructor);


}
