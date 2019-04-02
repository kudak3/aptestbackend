package com.aptest.Aptest.controller;

import com.aptest.Aptest.document.Exam;
import com.aptest.Aptest.document.Question;
import com.aptest.Aptest.repository.ExamRepository;
import com.aptest.Aptest.repository.QuestionRepository;
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
}
