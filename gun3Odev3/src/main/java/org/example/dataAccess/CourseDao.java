package org.example.dataAccess;

import org.example.entities.Course;

import java.util.List;

public interface CourseDao {
    void addCourse(Course course);
    List<Course> getAllCourses();
}
