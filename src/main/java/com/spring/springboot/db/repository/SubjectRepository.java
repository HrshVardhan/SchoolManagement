package com.spring.springboot.db.repository;

import com.spring.springboot.db.document.Subject;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectRepository extends MongoRepository<Subject, String> {

    public List<Subject> findCourseByEmail(String email);

    public void deleteByEmail(String email);

}
