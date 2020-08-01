package com.emysilva.karateschool.repository;

import com.emysilva.karateschool.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentRepository extends JpaRepository<Student, Long> {

}
