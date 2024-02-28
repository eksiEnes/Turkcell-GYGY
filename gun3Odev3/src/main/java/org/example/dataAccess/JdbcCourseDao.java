package org.example.dataAccess;

import org.example.entities.Course;

import java.util.List;

public class JdbcCourseDao implements CourseDao {

    private static JdbcCourseDao INSTANCE = null;
    private  Database database;

    private JdbcCourseDao() {
        this.database = Database.getInstance();
    }

    public static JdbcCourseDao getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new JdbcCourseDao();
        }
        return INSTANCE;
    }

    @Override
    public void addCourse(Course course) {
        database.addCourse(course);
    }

    @Override
    public List<Course> getAllCourses() {
        return database.getAllCourses();
    }
}