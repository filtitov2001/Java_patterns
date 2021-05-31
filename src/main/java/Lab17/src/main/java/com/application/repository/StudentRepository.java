package com.application.repository;

import com.application.models.Student;
import com.application.models.University;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;



@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    @Transactional
    void deleteAllByUniversity(University university);
}
