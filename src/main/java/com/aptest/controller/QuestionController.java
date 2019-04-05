package com.aptest.controller;

import com.aptest.document.Question;
import com.aptest.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class QuestionController {

    @Autowired
    private QuestionRepository questionRepository;

    @GetMapping("/questions")
    public List<Question> getAllQuestions(){
        return questionRepository.findAll();
    }

    @GetMapping("/question/{id}")
    public Question getOneQuestion(@PathVariable String id){
        return questionRepository.findById(id).get();
    }


    @PostMapping("/question")
    public List<Question> setQuestions(@RequestBody List<Question> question){



        return questionRepository.saveAll(question);
    }

    @PutMapping("/question")
    public Question updateQuestion(@RequestBody Question question){
        return questionRepository.findById(question.getId()).get();
    }

//    @DeleteMapping("/question/{name}")
//    public void deleteStuden(@PathVariable String name){
//        Question question = questionRepository.findQuestionByNameLike(name);
//
//        questionRepository.delete(question);
//
//    }
}
