package com.example.controller;

import com.example.response.StudentResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/student/")
public class StudentController {

    @GetMapping("/get")
    public StudentResponse getStudent(){
        StudentResponse sp = new StudentResponse(1, "Sritaj", "Patel");
        return sp;
    }
}
