package com.aptest.repository;

import com.aptest.document.Question;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends MongoRepository<Question,String> {

//    List<Question> findAllBySubjectAndEAndExamName(Subject subject,String examName);

}
