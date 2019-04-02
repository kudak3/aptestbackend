package com.aptest.Aptest.controller;

import com.aptest.Aptest.document.Subject;
import com.aptest.Aptest.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SubjectController {

    @Autowired
    private SubjectRepository subjectRepository;

    @GetMapping("/subjects")
    public List<Subject> getAllSubjects(){
        return subjectRepository.findAll();
    }

    @GetMapping("/subject/{id}")
    public Subject getOneSubject(@PathVariable String id){
        return subjectRepository.findById(id).get();
    }


    @PostMapping("/subject")
    public Subject registerSubject(@RequestBody Subject subject){
        return subjectRepository.save(subject);
    }

    @PutMapping("/subject")
    public Subject updateSubject(@RequestBody Subject subject){
        return subjectRepository.findById(subject.getId()).get();
    }

    @DeleteMapping("/subject/{name}")
    public void deleteStuden(@PathVariable String name){
        Subject subject = subjectRepository.findSubjectByNameLike(name);

        subjectRepository.delete(subject);

    }
}
