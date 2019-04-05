package com.aptest.repository;

import com.aptest.document.Teacher;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends MongoRepository<Teacher,String> {

    Teacher findTeacherByEcNo(String ecNo);

}
