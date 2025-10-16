package com.spring.boot.controller;
import com.spring.boot.dto.InstructorDto;
import com.spring.boot.model.Instructor;
import com.spring.boot.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InstructorController {

    private final InstructorService instructorService;

    @Autowired
    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @GetMapping("instructor/all")
    public List<InstructorDto> getAllInstructors() {
        return instructorService.getAllInstructors();
    }


    @PostMapping("instructor/save")
    public Instructor save(@RequestBody Instructor instructor) {
        return instructorService.save(instructor);
    }


    @GetMapping("instructor/Name/{name}")
    public InstructorDto getInstructorByName(@PathVariable String name) {
        return instructorService.getInstructorByName(name);
    }

    @GetMapping("instructor/id/{id}")
    public InstructorDto getInstructorById(@PathVariable long id) {
        return instructorService.getInstructorById(id);
    }
}
