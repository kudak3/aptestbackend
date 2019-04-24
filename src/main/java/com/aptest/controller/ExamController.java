package com.aptest.controller;

import com.aptest.document.Exam;
import com.aptest.document.Question;
import com.aptest.repository.ExamRepository;
import com.aptest.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ExamController {

    @Autowired
    ExamRepository examRepository;
    @Autowired
    QuestionRepository questionRepository;

    @GetMapping("/exam/{examName}")
    public Exam getExam(@PathVariable String examName){



        return examRepository.findByExamName(examName);

    }
    @PostMapping("/exam")
    public Exam setExam( @RequestBody Exam exam){
        System.out.println("========="+exam.toString());

        List<Question> questions = exam.getQuestionList();
        questionRepository.saveAll(questions);



        return examRepository.save(exam);

    }

    @GetMapping("/exams")
    public List<Exam> getExams(){

        System.out.println("=====here====");

        return examRepository.findAll();
    }
}
