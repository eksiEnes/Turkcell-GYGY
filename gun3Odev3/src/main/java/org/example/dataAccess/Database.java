package org.example.dataAccess;

import org.example.entities.Category;
import org.example.entities.Course;
import org.example.entities.Teacher;

import java.util.ArrayList;
import java.util.List;

public class Database {
    private static Database instance = null; // Singleton için
    private List<Course> courses;

    private Database() {
        this.courses = new ArrayList<>();
        addDefaultCourses();
    }

    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    public List<Course> getAllCourses() {
        return courses;
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    private void addDefaultCourses() {
        // Varsayılan kurslar
        Course course1 = new Course("Java", new Teacher("Engin Demirog"), new Category("Programming"), 150.50);
        Course course2 = new Course("Web Development", new Teacher("Jane Smith"), new Category("Web"), 300.5);
        Course course3 = new Course("Comedy native", new Teacher("Ricky Gervais"), new Category("Comedy"), 400.5);

        // Varsayılan kurslar listeye eklenir
        addCourse(course1);
        addCourse(course2);
        addCourse(course3);
    }
}