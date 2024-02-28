package org.example.dataAccess;

import org.example.entities.Course;

import java.util.List;

public class HibernateCourseDao implements CourseDao {
    private static HibernateCourseDao INSTANCE = null;
    private Database database;

    private HibernateCourseDao() {
        this.database = Database.getInstance();
    }

    public static HibernateCourseDao getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new HibernateCourseDao();
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