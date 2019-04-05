package com.aptest.repository;

import com.aptest.document.Exam;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamRepository extends MongoRepository<Exam,String> {
    Exam findByExamName(String examName);
}
