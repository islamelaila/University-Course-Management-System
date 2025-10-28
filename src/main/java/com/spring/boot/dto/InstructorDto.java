package com.spring.boot.dto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spring.boot.model.Course;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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
public class InstructorDto {


    private  long id;
    @NotBlank(message = "Name is mandatory")
    private  String name;

    @NotBlank(message = "Email is mandatory")
    private  String email;

    @OneToMany(mappedBy = "instructor")
    @JsonIgnoreProperties("instructor")
    private List<Course> courses;
    ;


}
