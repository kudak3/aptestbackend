package com.aptest.Aptest.repository;

import com.aptest.Aptest.document.Subject;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SubjectRepository extends MongoRepository<Subject,String> {
    Subject findSubjectByNameLike(String name);
}
