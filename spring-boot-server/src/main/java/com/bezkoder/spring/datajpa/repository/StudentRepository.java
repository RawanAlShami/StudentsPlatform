package com.bezkoder.spring.datajpa.repository;

import com.bezkoder.spring.datajpa.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StudentRepository extends JpaRepository<Student, Long>
{
    @Query("SELECT s FROM Student s WHERE s.username = ?1")
    public Student findByName(String username);
}
