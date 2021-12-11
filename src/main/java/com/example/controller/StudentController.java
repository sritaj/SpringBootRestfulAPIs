package com.example.controller;

import com.example.entity.Student;
import com.example.request.CreateRequestStudent;
import com.example.response.StudentResponse;
import com.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/student/")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("getAll")
    public List<StudentResponse> getAllStudents(){

        List<Student> studentList =  studentService.getAllStudents();
        List<StudentResponse> studentResponseList = new ArrayList<>();
        studentList.forEach(student->studentResponseList.add(new StudentResponse(student)));
        return studentResponseList;
    }

    @PostMapping("create")
    public StudentResponse createStudent(@RequestBody CreateRequestStudent createRequestStudent) {
        Student student =  studentService.createStudent(createRequestStudent);
        return new StudentResponse(student);
    }

}
