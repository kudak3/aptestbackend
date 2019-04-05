package com.aptest.repository;

import com.aptest.document.Subject;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SubjectRepository extends MongoRepository<Subject,String> {
    Subject findSubjectByNameLike(String name);
}
