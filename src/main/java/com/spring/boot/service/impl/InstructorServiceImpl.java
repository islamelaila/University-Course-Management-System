package com.spring.boot.service.impl;
import com.spring.boot.dto.InstructorDto;
import com.spring.boot.mapper.InstructorMapper;
import com.spring.boot.model.Instructor;
import com.spring.boot.repo.InstructorRepo;
import com.spring.boot.service.InstructorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Objects;

@Service
public class InstructorServiceImpl implements InstructorService {


    private InstructorRepo instructorRepo;

    private InstructorMapper instructorMapper;

    @Autowired
    public InstructorServiceImpl(InstructorRepo instructorRepo , InstructorMapper instructorMapper ) {
        this.instructorRepo = instructorRepo;
        this.instructorMapper = instructorMapper;
    }


    @Override
    public InstructorDto save(InstructorDto instructorDto) {
        if(!Objects.nonNull(instructorDto.getId())){
            throw new IllegalArgumentException("Id should not be null for new Instructor");
        }
        Instructor instructor = instructorRepo.save(instructorMapper.toEntity(instructorDto));
        instructorDto.setId(instructor.getId());
        return instructorDto;
    }

    @Override
    public List<InstructorDto> getAllInstructors() {
        List<Instructor> instructors = instructorRepo.findAll();

        return instructors.stream().map(instructor -> instructorMapper.toDto(instructor)).toList();
    }

    @Override
    public InstructorDto getInstructorByName(String name) {
        if(name == null || name.isEmpty() || name.isBlank() || instructorRepo.findByName(name) == null) {
            throw new IllegalArgumentException("Instructor with name " + name + " not found");
        }
        Instructor instructor = instructorRepo.findByName(name);
        return instructorMapper.toDto(instructor);
    }

    @Override
    public InstructorDto getInstructorById(long id) {
        if(instructorRepo.findById(id).isEmpty()){
            throw new IllegalArgumentException("Instructor with id " + id + " not found");
        }
        Instructor instructor = instructorRepo.findById(id).orElse(null);
        return instructorMapper.toDto(instructor);
    }


}
