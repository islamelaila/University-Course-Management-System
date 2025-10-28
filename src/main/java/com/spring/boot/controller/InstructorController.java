package com.spring.boot.controller;
import com.spring.boot.dto.InstructorDto;
import com.spring.boot.model.Instructor;
import com.spring.boot.service.InstructorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class InstructorController {

    private final InstructorService instructorService;

    @Autowired
    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @GetMapping("instructor/all")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<List<InstructorDto>> getAllInstructors() {
        return ResponseEntity.ok(instructorService.getAllInstructors());
    }


    @PostMapping("instructor/save")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<InstructorDto> save(@RequestBody @Valid InstructorDto instructorDto) throws URISyntaxException {
        return ResponseEntity.created(new URI("/instructor/save")).body(instructorService.save(instructorDto));
    }


    @GetMapping("instructor/Name/{name}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<InstructorDto> getInstructorByName(@PathVariable String name) {
        return ResponseEntity.ok(instructorService.getInstructorByName(name));
    }

    @GetMapping("instructor/id/{id}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<InstructorDto> getInstructorById(@PathVariable long id) {
        return ResponseEntity.ok(instructorService.getInstructorById(id));
    }
}
