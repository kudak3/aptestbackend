package com.aptest.Aptest.controller;

import com.aptest.Aptest.document.Student;
import com.aptest.Aptest.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@RestController
public class StudentController {


    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/students")
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    @GetMapping("/student/{id}")
    public Student getOneStudent(@PathVariable String id){
        return studentRepository.findById(id).get();
    }


    @PostMapping("/student")
    public Student registerStudent(@RequestBody Student student){
        return studentRepository.save(student);
    }

    @PutMapping("/student")
    public Student updateStudent(@RequestBody Student student){
        return studentRepository.findById(student.getId()).get();
    }

    @DeleteMapping("/student/{ecNo}")
    public void deleteStuden(@PathVariable String idNum){
        Student student = studentRepository.findStudentByIdNum(idNum);

        studentRepository.delete(student);

    }
}
