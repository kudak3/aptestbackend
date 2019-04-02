package com.aptest.Aptest.repository;

import com.aptest.Aptest.document.Syllabus;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SyllabusRepository extends MongoRepository<Syllabus,String> {
    Syllabus findSyllabusByNameLike(String name);
}
