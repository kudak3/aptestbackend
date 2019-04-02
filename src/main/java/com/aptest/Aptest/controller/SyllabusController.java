package com.aptest.Aptest.controller;

import com.aptest.Aptest.document.Syllabus;
import com.aptest.Aptest.repository.SyllabusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api")
public class SyllabusController {
    @Autowired
    private SyllabusRepository syllabusRepository;

    @GetMapping("/syllabus")
    public List<Syllabus> getAllSyllabus(){
        return syllabusRepository.findAll();
    }

    @GetMapping("/syllabus/{id}")
    public Syllabus getOneSyllabus(@PathVariable String id){
        return syllabusRepository.findById(id).get();
    }


    @PostMapping("/syllabus")
    public Syllabus registerSyllabus(@RequestBody Syllabus syllabus){
        return syllabusRepository.save(syllabus);
    }

    @PutMapping("/syllabus")
    public Syllabus updateSyllabus(@RequestBody Syllabus syllabus){
        return syllabusRepository.findById(syllabus.getId()).get();
    }

    @DeleteMapping("/syllabus/{name}")
    public void deleteStudent(@PathVariable String name){
        Syllabus syllabus = syllabusRepository.findSyllabusByNameLike(name);

        syllabusRepository.delete(syllabus);

    }
}
