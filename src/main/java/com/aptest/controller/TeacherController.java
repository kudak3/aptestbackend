package com.aptest.controller;

import com.aptest.document.Teacher;
import com.aptest.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@RestController
public class TeacherController {

    @Autowired
    private TeacherRepository teacherRepository;


    @GetMapping("/teachers")
    public List<Teacher> getAllTeachers(){
        return teacherRepository.findAll();
    }

    @GetMapping("/teacher/{ecNo}")
    public Teacher getOneTeacher(@PathVariable String ecNo){
        return teacherRepository.findTeacherByEcNo(ecNo);
    }

    @PostMapping("/teacher")
    public Teacher addTeacher(@RequestBody Teacher teacher){
        return teacherRepository.save(teacher);
    }
    @DeleteMapping("/teacher/{ecNo}")
    public void deleteTeacher(@PathVariable String ecNo){
        Teacher teacher = teacherRepository.findTeacherByEcNo(ecNo);

        teacherRepository.delete(teacher);

    }
}
