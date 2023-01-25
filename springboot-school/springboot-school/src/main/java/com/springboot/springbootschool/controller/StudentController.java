package com.springboot.springbootschool.controller;

import com.springboot.springbootschool.entity.Student;
import com.springboot.springbootschool.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @GetMapping
    public List<Student> getStudent() {
        return this.studentRepository.findAll();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable(value = "id") Long studentId) {
        return this.studentRepository.findById(studentId).get();
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return this.studentRepository.save(student);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@RequestBody Student student, @PathVariable("id") Long studentId) {
        Student existingStudent = this.studentRepository.findById(studentId).get();
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        return this.studentRepository.save(existingStudent);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Student> deleteStudent(@RequestBody Student student, @PathVariable("id") Long studentId) {
        Student existingStudent = this.studentRepository.findById(studentId).get();
        this.studentRepository.delete(existingStudent);
        return ResponseEntity.ok().build();
    }
}
