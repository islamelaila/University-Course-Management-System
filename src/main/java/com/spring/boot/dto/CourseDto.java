package com.spring.boot.dto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spring.boot.model.Instructor;
import com.spring.boot.model.Student;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CourseDto {


    private long id;

    @Column(unique = true)
    private String title;
    private String description;

    @ManyToMany(mappedBy = "courses")
    @JsonIgnoreProperties("students")
    private List<Student> students;

    @ManyToOne
    @JoinColumn(name = "instructor_course", nullable = false)
    @JsonIgnoreProperties("courses")
    private Instructor instructor;

}
