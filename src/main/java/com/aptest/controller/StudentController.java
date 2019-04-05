package com.aptest.controller;

import com.aptest.document.Student;
import com.aptest.mail.NotificationService;
import com.aptest.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@RestController
public class StudentController {


    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    NotificationService notificationService;

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

        Student student1 =studentRepository.save(student);


        return student1;
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
