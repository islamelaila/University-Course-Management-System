package com.spring.boot.service;

import com.spring.boot.dto.InstructorDto;
import com.spring.boot.model.Instructor;

import java.util.List;

public interface InstructorService {

    InstructorDto save(InstructorDto instructorDto);

    List<InstructorDto> getAllInstructors();


    InstructorDto getInstructorByName(String name);


    InstructorDto getInstructorById(long id);


}
