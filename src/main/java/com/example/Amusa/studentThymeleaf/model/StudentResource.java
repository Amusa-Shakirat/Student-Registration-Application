package com.example.Amusa.studentThymeleaf.model;

import lombok.Data;
import org.springframework.hateoas.RepresentationModel;


@Data
public class StudentResource extends RepresentationModel<StudentResource> {

public Student student;
}


