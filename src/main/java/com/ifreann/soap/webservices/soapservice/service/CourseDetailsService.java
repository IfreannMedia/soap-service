package com.ifreann.soap.webservices.soapservice.service;

import com.ifreann.soap.webservices.soapservice.bean.Course;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CourseDetailsService {

    private static List<Course> courses = new ArrayList<>();

    static {
        Course course1 = new Course(1, "Spring", "10 Steps");
        courses.add(course1);

        Course course2 = new Course(1, "Spring MVC", "10 Examples");
        courses.add(course2);

        Course course3 = new Course(1, "Spring Boot", "6K Studnets");
        courses.add(course3);

        Course course4 = new Course(1, "Maven", "Popular Maven course");
        courses.add(course3);
    }

    public Course findById(int id) {
        return courses.stream().filter(course -> course.getId() == id).findFirst().orElse(null);
    }

    public List<Course> getAllCourses() {
        return courses;
    }

    public int deleteCourseById(int id) {
        try {
            courses = courses.stream().filter(c -> c.getId() != id).collect(Collectors.toList());
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }
}
