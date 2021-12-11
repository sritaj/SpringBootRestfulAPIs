package com.example.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class CreateRequestStudent {

    @JsonProperty("first_name")
    @NotBlank(message = "First Name is Required!")
    private String firstName;

    private String lastName;

    private String email;
}
