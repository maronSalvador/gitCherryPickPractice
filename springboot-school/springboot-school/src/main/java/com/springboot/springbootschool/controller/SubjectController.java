package com.springboot.springbootschool.controller;

import com.springboot.springbootschool.entity.Student;
import com.springboot.springbootschool.entity.Subject;
import com.springboot.springbootschool.entity.Teacher;
import com.springboot.springbootschool.repository.StudentRepository;
import com.springboot.springbootschool.repository.SubjectRepository;
import com.springboot.springbootschool.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.security.auth.Subject;
import java.util.List;

@RestController
@RequestMapping("/api/subjects")
public class SubjectController {

    @Autowired
    SubjectRepository subjectRepository;
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    TeacherRepository teacherRepository;

    @GetMapping
    public List<Subject> getSubject() {
        return this.subjectRepository.findAll();
    }

    @GetMapping("/{id}")
    public Subject getSubjectById(@RequestBody Subject subject, @PathVariable(value = "id") Long subjectId) {
        return this.subjectRepository.findById(subjectId).get();
    }

    @PostMapping
    public Subject createSubject(@RequestBody Subject subject) {
        return this.subjectRepository.save(subject);
    }

    @PutMapping("/{subjectId}/students/{studentId}")
    public Subject enrolledStudentsToSubjects(@PathVariable Long subjectId, @PathVariable Long studentId) {
        Subject subject = this.subjectRepository.findById(subjectId).get();
        Student student = this.studentRepository.findById(studentId).get();
        subject.enrollStudent(student);
        return this.subjectRepository.save(subject);

    }

    @PutMapping("/{subjectId}/teachers/{teacherId}")
    public Subject assignTeacherToSubject(@PathVariable Long subjectId, @PathVariable Long teacherId) {
        Subject subject = this.subjectRepository.findById(subjectId).get();
        Teacher teacher = this.teacherRepository.findById(teacherId).get();
        subject.assignTeacher(teacher);
        return this.subjectRepository.save(subject);

    }


}
