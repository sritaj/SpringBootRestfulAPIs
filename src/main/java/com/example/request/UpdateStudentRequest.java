package com.example.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Setter
@Getter
public class UpdateStudentRequest {

    @NotNull(message = "Student ID is Required!")
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
}
