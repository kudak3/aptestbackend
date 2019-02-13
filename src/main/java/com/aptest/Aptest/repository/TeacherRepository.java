package com.aptest.Aptest.repository;

import com.aptest.Aptest.document.Teacher;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends MongoRepository<Teacher,String> {

    Teacher findTeacherByEcNo(String ecNo);

}
