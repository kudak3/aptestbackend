package com.aptest.Aptest.repository;

import com.aptest.Aptest.document.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends MongoRepository<Student,String> {
    Student findStudentByIdNum(String idNum);
}
