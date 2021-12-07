package com.ifreann.soap.webservices.soapservice.service;

import com.ifreann.soap.webservices.soapservice.Status;
import com.ifreann.soap.webservices.soapservice.bean.Course;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class CourseDetailsService {

    private static List<Course> courses = new ArrayList<>();

    static {
        Course course1 = new Course(1, "Spring", "10 Steps");
        courses.add(course1);

        Course course2 = new Course(2, "Spring MVC", "10 Examples");
        courses.add(course2);

        Course course3 = new Course(3, "Spring Boot", "6K Studnets");
        courses.add(course3);

        Course course4 = new Course(4, "Maven", "Popular Maven course");
        courses.add(course4);
    }

    public Course findById(int id) {
        return courses.stream().filter(course -> course.getId() == id).findFirst().orElse(null);
    }

    public List<Course> getAllCourses() {
        return courses;
    }

    public Status deleteCourseById(int id) {
        if (courses == null || courses.isEmpty()) {
            return Status.FAILURE;
        }
        Iterator<Course> coursesIt = courses.iterator();
        while (coursesIt.hasNext()) {
            Course course = coursesIt.next();
            if (course.getId() == id) {
                coursesIt.remove();
                return Status.SUCCESS;
            }
        }
        return Status.FAILURE;
    }
}
