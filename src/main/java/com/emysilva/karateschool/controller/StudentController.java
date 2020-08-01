package com.emysilva.karateschool.controller;

import com.emysilva.karateschool.exception.ResourceNotFoundException;
import com.emysilva.karateschool.model.Student;
import com.emysilva.karateschool.repository.StudentRepository;
import org.aspectj.apache.bcel.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.awt.print.Pageable;
import java.util.Collections;
import java.util.List;


@RestController
@RequestMapping("/api/auth")
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;

    @CrossOrigin
    @PostMapping("/student")
    public Student createStudent(@Valid @RequestBody Student student) {
        Student student1 = studentRepository.save(student);
        return student1;
    }

    @CrossOrigin
    @GetMapping("/student")
    public List<Student> listStudents(Student student) {
        return studentRepository.findAll();
    }

    @CrossOrigin
    @GetMapping("/student/{id}")
    public Student getById(@PathVariable Long id) {
        Student student = studentRepository.getOne(id);
        return student;
    }

    @CrossOrigin
    @DeleteMapping("/student/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        return studentRepository.findById(id)
                .map(student -> {
                    studentRepository.delete(student);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Student not found with id " + id));
    }
}
