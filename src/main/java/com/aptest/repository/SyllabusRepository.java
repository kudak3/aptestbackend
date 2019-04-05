package com.aptest.repository;

import com.aptest.document.Syllabus;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SyllabusRepository extends MongoRepository<Syllabus,String> {
    Syllabus findSyllabusByNameLike(String name);
}
