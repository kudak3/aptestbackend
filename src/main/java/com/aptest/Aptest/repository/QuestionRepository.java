package com.aptest.Aptest.repository;

import com.aptest.Aptest.document.Question;
import com.aptest.Aptest.document.Subject;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends MongoRepository<Question,String> {

//    List<Question> findAllBySubjectAndEAndExamName(Subject subject,String examName);

}
