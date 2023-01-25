package com.springboot.springbootschool.controller;

import com.springboot.springbootschool.entity.Teacher;
import com.springboot.springbootschool.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teachers")
public class TeacherController {

    @Autowired
    TeacherRepository teacherRepository;

    @GetMapping
    List<Teacher> getTeacher() {
        return this.teacherRepository.findAll();
    }

    @GetMapping("/{id}")
    Teacher getTeacherById(@PathVariable(value = "id") Long teacherId) {
        return this.teacherRepository.findById(teacherId).get();
    }

    @PostMapping
    Teacher createTeacher(@RequestBody Teacher teacher) {
        return this.teacherRepository.save(teacher);
    }

    @PutMapping("/{id}")
    Teacher updateTeacher(@RequestBody Teacher teacher, @PathVariable("id") Long teacherId) {
        Teacher existingTeacher = this.teacherRepository.findById(teacherId).get();
        existingTeacher.setFirstName(teacher.getFirstName());
        existingTeacher.setLastName(teacher.getLastName());
        return this.teacherRepository.save(existingTeacher);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Teacher> deleteTeacher(@RequestBody Teacher teacher, @PathVariable("id") Long teacherId) {
        Teacher existingTeacher = this.teacherRepository.findById(teacherId).get();
        this.teacherRepository.delete(existingTeacher);
        return ResponseEntity.ok().build();
    }
}
