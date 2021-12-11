package com.example.service;

import com.example.entity.Student;
import com.example.repository.StudentRepository;
import com.example.request.CreateRequestStudent;
import com.example.request.UpdateStudentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public Student createStudent(CreateRequestStudent createRequestStudent){
        Student student = new Student(createRequestStudent);
        return studentRepository.save(student);
    }

    public Student updateStudent(UpdateStudentRequest updateStudentRequest){
        Student student = studentRepository.findById(updateStudentRequest.getId()).get();

        if(updateStudentRequest.getFirstName()!=null && !updateStudentRequest.getFirstName().isEmpty()){
            student.setFirstName(updateStudentRequest.getFirstName());
        }
        return studentRepository.save(student);
    }

    public String deleteStudent(long id){
        studentRepository.deleteById(id);
        return "Student has been deleted successfully";
    }
}
