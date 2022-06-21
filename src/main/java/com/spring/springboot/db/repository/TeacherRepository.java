package com.spring.springboot.db.repository;

import com.spring.springboot.db.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, String> {
    public boolean existsByEmail(String email);
    public List<Teacher> findByEmail(String email);

    public void deleteByEmail(String email);
}
