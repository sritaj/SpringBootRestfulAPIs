package com.example.controller;

import com.example.entity.Student;
import com.example.request.CreateRequestStudent;
import com.example.request.InQueryRequest;
import com.example.request.UpdateStudentRequest;
import com.example.response.StudentResponse;
import com.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/student/")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("getAll")
    public List<StudentResponse> getAllStudents() {

        List<Student> studentList = studentService.getAllStudents();
        List<StudentResponse> studentResponseList = new ArrayList<>();
        studentList.forEach(student -> studentResponseList.add(new StudentResponse(student)));
        return studentResponseList;
    }

    @PostMapping("create")
    public StudentResponse createStudent(@Valid @RequestBody CreateRequestStudent createRequestStudent) {
        Student student = studentService.createStudent(createRequestStudent);
        return new StudentResponse(student);
    }

    @PutMapping("update")
    public StudentResponse updateStudent(@Valid @RequestBody UpdateStudentRequest updateStudentRequest) {
        Student student = studentService.updateStudent(updateStudentRequest);
        return new StudentResponse(student);
    }

    @DeleteMapping("delete")
    public String deleteStudent(@RequestParam long id) {
        return studentService.deleteStudent(id);
    }

    @DeleteMapping("deleteStudent/{id}")
    public String deleteSpecifiedStudent(@PathVariable long id) {
        return studentService.deleteStudent(id);
    }

    @GetMapping("getByFirstName/{firstName}")
    public List<StudentResponse> getByFirstName(@PathVariable String firstName){
        List<Student> studentList = studentService.getByFirstName(firstName);

        List<StudentResponse> studentResponseList = new ArrayList<>();
        studentList.forEach(student -> studentResponseList.add(new StudentResponse(student)));
        return studentResponseList;
    }

    @GetMapping("getByFirstNameAndLastName/{firstName}/{lastName}")
    public StudentResponse getByFirstNameAndLastName(@PathVariable String firstName, @PathVariable String lastName){
        return new StudentResponse(studentService.getByFirstNameAndLastName(firstName, lastName));
    }

    @GetMapping("getByFirstNameORLastName/{firstName}/{lastName}")
    public List<StudentResponse> getByFirstNameORLastName(@PathVariable String firstName, @PathVariable String lastName){
        List<Student> studentList = studentService.getByFirstNameOrLastName(firstName, lastName);

        List<StudentResponse> studentResponseList = new ArrayList<>();
        studentList.forEach(student -> studentResponseList.add(new StudentResponse(student)));
        return studentResponseList;
    }

    @GetMapping("getByFirstNameIn")
    public List<StudentResponse> getByFirstNameIn(@RequestBody InQueryRequest inQueryRequest){
        List<Student> studentList = studentService.getByFirstNameIn(inQueryRequest);

        List<StudentResponse> studentResponseList = new ArrayList<>();
        studentList.forEach(student -> studentResponseList.add(new StudentResponse(student)));
        return studentResponseList;

    }

    @GetMapping("gellAllWithPagination")
    public List<StudentResponse> getAllStudentsWithPagination(@RequestParam int pageNo, @RequestParam int pageSize){
        List<Student> studentList = studentService.getAllStudentsWithPagination(pageNo, pageSize);

        List<StudentResponse> studentResponseList = new ArrayList<>();
        studentList.forEach(student -> studentResponseList.add(new StudentResponse(student)));
        return studentResponseList;
    }

    @GetMapping("getAllWithSorting")
    public List<StudentResponse> getAllStudentsWithSorting(){
        List<Student> studentList = studentService.getAllStudentsWithSorting();

        List<StudentResponse> studentResponseList = new ArrayList<>();
        studentList.forEach(student -> studentResponseList.add(new StudentResponse(student)));
        return studentResponseList;
    }

    @GetMapping("like/{firstName}")
    public List<StudentResponse> like(@PathVariable String firstName){
        List<Student> studentList = studentService.like(firstName);

        List<StudentResponse> studentResponseList = new ArrayList<>();
        studentList.forEach(student -> studentResponseList.add(new StudentResponse(student)));
        return studentResponseList;
    }

    @GetMapping("startsWith/{firstName}")
    public List<StudentResponse> startWiths(@PathVariable String firstName){
        List<Student> studentList = studentService.startWiths(firstName);

        List<StudentResponse> studentResponseList = new ArrayList<>();
        studentList.forEach(student -> studentResponseList.add(new StudentResponse(student)));
        return studentResponseList;
    }

    @GetMapping("endsWith/{firstName}")
    public List<StudentResponse> endsWith(@PathVariable String firstName){
        List<Student> studentList = studentService.endsWith(firstName);

        List<StudentResponse> studentResponseList = new ArrayList<>();
        studentList.forEach(student -> studentResponseList.add(new StudentResponse(student)));
        return studentResponseList;
    }

    @GetMapping("getStudentByFirstNameAndLastName/{firstName}/{lastName}")
    public StudentResponse getStudentByFirstNameAndLastName(@PathVariable String firstName, @PathVariable String lastName){
        return new StudentResponse(studentService.getStudentByFirstNameAndLastName(firstName, lastName));
    }
}
