package org.example.Business;

import org.example.dataAccess.CourseDao;
import org.example.dataAccess.HibernateCourseDao;
import org.example.dataAccess.JdbcCourseDao;
import org.example.entities.Course;
import org.example.logging.Logger;

import java.util.List;

public class CourseManager {
    private CourseDao courseDao;
    private Logger[] loggers;

    public CourseManager(ConnectionType type,Logger[] loggers ) {
        switch (type){

            case JDBC -> {
                this.courseDao = JdbcCourseDao.getINSTANCE();
            }
            case HIBERNATE -> {
                this.courseDao = HibernateCourseDao.getINSTANCE();
            }
        }

        this.loggers = loggers;
    }

    public void addCourse(Course course) {
        // İstenen kontrolleri yapalım
        if (course.getName() == null || course.getName().isEmpty()) {
            throw new IllegalArgumentException("Kurs ismi boş olamaz.");
        }

        if (course.getTeacher() == null || course.getTeacher().getTeacherName() == null || course.getTeacher().getTeacherName().isEmpty()) {
            throw new IllegalArgumentException("Eğitmen ismi boş olamaz.");
        }

        if (course.getCategory() == null || course.getCategory().getCategoryName() == null || course.getCategory().getCategoryName().isEmpty()) {
            throw new IllegalArgumentException("Kategori ismi boş olamaz.");
        }
        if (course.getPrice() < 0) {
            throw new IllegalArgumentException("Kurs fiyatı 0'dan küçük olamaz.");
        }



        // Database'den mevcut kursları al
        List<Course> coursesInDatabase = courseDao.getAllCourses();

        // Kurs ismi ve kategori ismi tekrarı kontrolü
        for (Course existingCourse : coursesInDatabase) {
            if (existingCourse.getName().equals(course.getName())) {
                throw new IllegalArgumentException("Bu isimde bir kurs zaten mevcut.");
            }
            if (existingCourse.getCategory().getCategoryName().equals(course.getCategory().getCategoryName())) {
                throw new IllegalArgumentException("Bu isimde bir kategori zaten mevcut.");
            }
        }
        for (Logger logger :loggers){ //db, file
            logger.log(course.getName());
        }

        // Kurs ekleme işlemini gerçekleştir
        courseDao.addCourse(course);
    }

    public List<Course> getAllCourses() {
        return courseDao.getAllCourses();
    }
}