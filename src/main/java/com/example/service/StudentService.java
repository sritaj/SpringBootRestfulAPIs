package com.example.service;

import com.example.entity.Student;
import com.example.repository.StudentRepository;
import com.example.request.CreateRequestStudent;
import com.example.request.InQueryRequest;
import com.example.request.UpdateStudentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student createStudent(CreateRequestStudent createRequestStudent) {
        Student student = new Student(createRequestStudent);
        return studentRepository.save(student);
    }

    public Student updateStudent(UpdateStudentRequest updateStudentRequest) {
        Student student = studentRepository.findById(updateStudentRequest.getId()).get();

        if (updateStudentRequest.getFirstName() != null && !updateStudentRequest.getFirstName().isEmpty()) {
            student.setFirstName(updateStudentRequest.getFirstName());
        }
        return studentRepository.save(student);
    }

    public String deleteStudent(long id) {
        studentRepository.deleteById(id);
        return "Student has been deleted successfully";
    }

    public List<Student> getByFirstName(String firstName) {
        return studentRepository.findByFirstName(firstName);
    }

    public Student getByFirstNameAndLastName(String firstName, String lastName) {
        return studentRepository.findByFirstNameAndLastName(firstName, lastName);
    }

    public List<Student> getByFirstNameOrLastName(String firstName, String lastName) {
        return studentRepository.findByFirstNameOrLastName(firstName, lastName);
    }

    public List<Student> getByFirstNameIn(InQueryRequest inQueryRequest) {
        return studentRepository.findByFirstNameIn(inQueryRequest.getFirstNames());
    }

    public List<Student> getAllStudentsWithPagination(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return studentRepository.findAll(pageable).getContent();
    }

    public List<Student> getAllStudentsWithSorting() {
        Sort sort = Sort.by(Sort.Direction.ASC, "firstName");
        return studentRepository.findAll(sort);
    }

    public List<Student> like(String firstName) {
        return studentRepository.findByFirstNameContains(firstName);
    }

    public List<Student> startWiths(String firstName) {
        return studentRepository.findByFirstNameStartsWith(firstName);
    }

    public List<Student> endsWith(String firstName) {
        return studentRepository.findByFirstNameEndsWith(firstName);
    }

    public Student getStudentByFirstNameAndLastName(String firstName, String lastName) {
        return studentRepository.findStudentByFirstNameAndLastName(firstName, lastName);
    }

    public Integer updateStudentFirstName(Long id, String firstName) {
        return studentRepository.updateStudent(id, firstName);
    }

    public Integer deleteStudent(String firstName){
        return studentRepository.deleteStudent(firstName);
    }
}
