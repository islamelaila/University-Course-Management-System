package com.spring.boot.service.impl;
import com.spring.boot.dto.InstructorDto;
import com.spring.boot.mapper.InstructorMapper;
import com.spring.boot.model.Instructor;
import com.spring.boot.repo.InstructorRepo;
import com.spring.boot.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public Instructor save(Instructor instructor) {
        return instructorRepo.save(instructor);
    }

    @Override
    public List<InstructorDto> getAllInstructors() {
        List<Instructor> instructors = instructorRepo.findAll();

        return instructors.stream().map(instructor -> instructorMapper.toDto(instructor)).toList();
    }

    @Override
    public InstructorDto getInstructorByName(String name) {
        Instructor instructor = instructorRepo.findByName(name);
        return instructorMapper.toDto(instructor);
    }

    @Override
    public InstructorDto getInstructorById(long id) {
        Instructor instructor = instructorRepo.findById(id).orElse(null);
        return instructorMapper.toDto(instructor);
    }


}
