package org.example;

import org.example.Business.ConnectionType;
import org.example.Business.CourseManager;
import org.example.entities.Category;
import org.example.entities.Course;
import org.example.entities.Teacher;
import org.example.logging.DatabaseLogger;
import org.example.logging.FileLogger;
import org.example.logging.Logger;

import java.util.List;

public class Main {
    public static void main(String[] args) {


        Logger[] loggers = {new DatabaseLogger(), new FileLogger()};

        CourseManager courseManager = new CourseManager(ConnectionType.JDBC, loggers);
        CourseManager courseManager2 = new CourseManager(ConnectionType.HIBERNATE, loggers);

        Course course1 = new Course("Kotlin", new Teacher("Burak"), new Category("Mobile") , 500.0);
        courseManager.addCourse(course1);

        Course course2 = new Course("Assembly", new Teacher("Abdullah"), new Category("History") , 520.0);
        courseManager2.addCourse(course2);

        // Aynı Course isminde hata kontrolü
        //Course course3 = new Course("Kotlin", new Teacher("Burak"), new Category("Mobile"));
        //courseManager.addCourse(course2);


        // Aynı Catergory isminde hata kontrolü
        //Course course4 = new Course("Flutter", new Teacher("Burak"), new Category("Mobile"));
        //courseManager.addCourse(course3);


        List<Course> courses = courseManager.getAllCourses();
        System.out.println("Tüm Kurslar:");
        for (Course course : courses) {
            System.out.println(course.getName() + " - " + course.getTeacher().getTeacherName() + " - " + course.getCategory().getCategoryName());
        }



    }
}
