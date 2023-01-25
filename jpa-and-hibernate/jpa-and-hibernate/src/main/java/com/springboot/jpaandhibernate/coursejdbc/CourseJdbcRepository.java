package com.springboot.jpaandhibernate.coursejdbc;

import com.springboot.jpaandhibernate.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJdbcRepository {
    @Autowired
    private JdbcTemplate springJdbcTemplate;

    private static String INSERT_QEURY =
            """
                            insert into course (id, name, author)
                            values(?, ?, ?)
            """;

    private static String DELETE_QEURY =
            """
                            delete from course
                            where id  = ?
            """;
    private static String SELECT_QEURY =
            """
                            select * from course
                            where id  = ?
            """;

    public void insert(Course course) {
        springJdbcTemplate.update(INSERT_QEURY,
                course.getId(),
                course.getName(),
                course.getAuthor());
    }

    public void deleteById(long id) {
        springJdbcTemplate.update(DELETE_QEURY, id);
    }

    public Course findById(long id) {
        return springJdbcTemplate.queryForObject(SELECT_QEURY, new BeanPropertyRowMapper<>(Course.class), id);
    }
}
