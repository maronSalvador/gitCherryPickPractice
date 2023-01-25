package com.springboot.jpaandhibernate.coursejdbc;

import com.springboot.jpaandhibernate.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner {

    @Autowired
    private CourseJdbcRepository courseJdbcRepository;

    @Override
    public void run(String... args) throws Exception {
        courseJdbcRepository.insert(new Course(1, "Learn Thermodynamics Now!", "Sta. Maria"));
        courseJdbcRepository.insert(new Course(2, "Learn Machine Design Now!", "Sta. Maria"));
        courseJdbcRepository.insert(new Course(3, "Learn Fluid Mechanics Now!", "Sta. Maria"));

        courseJdbcRepository.deleteById(1);

        System.out.println(courseJdbcRepository.findById(2));
        System.out.println(courseJdbcRepository.findById(3));
    }
}
