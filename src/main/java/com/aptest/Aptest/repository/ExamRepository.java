package com.aptest.Aptest.repository;

import com.aptest.Aptest.document.Exam;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamRepository extends MongoRepository<Exam,String> {
    Exam findByExamName(String examName);
}
