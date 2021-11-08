package com.ifreann.soap.webservices.soapservice.soap;

import com.ifreann.soap.webservices.soapservice.*;
import com.ifreann.soap.webservices.soapservice.bean.Course;
import com.ifreann.soap.webservices.soapservice.service.CourseDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.ArrayList;
import java.util.List;

@Endpoint
public class CourseDetailsEndpoint {

    @Autowired
    private CourseDetailsService courseDetailsService;

    @PayloadRoot(namespace = "http://ifreann.com/courses", localPart = "GetCourseDetailsRequest")
    @ResponsePayload
    public GetCourseDetailsResponse processCourseDetailsRequest(@RequestPayload GetCourseDetailsRequest request) {
        Course course = courseDetailsService.findById(request.getId());

        return getCourseDetailsResponse(course);
    }

    @PayloadRoot(namespace = "http://ifreann.com/courses", localPart = "GetAllCourseDetailsRequest")
    @ResponsePayload
    public GetAllCourseDetailsResponse processAllCourseDetailsRequest(@RequestPayload GetAllCourseDetailsRequest request) {
        List<Course> courses = courseDetailsService.getAllCourses();

        return getAllCourseDetailsResponse(courses);
    }

    private GetAllCourseDetailsResponse getAllCourseDetailsResponse(final List<Course> courses) {
        GetAllCourseDetailsResponse response = new GetAllCourseDetailsResponse();
        response.getAllCourseDetails().addAll(mapCourseListToCourseDetailsList(courses));
        return response;
    }

    private GetCourseDetailsResponse getCourseDetailsResponse(Course course) {
        GetCourseDetailsResponse response = new GetCourseDetailsResponse();
        CourseDetails courseDetails = mapCourseToCourseDetails(course);
        response.setCourseDetails(courseDetails);
        return response;
    }

    private CourseDetails mapCourseToCourseDetails(Course course) {
        CourseDetails courseDetails = new CourseDetails();
        courseDetails.setId(course.getId());
        courseDetails.setName(course.getName());
        courseDetails.setDescription(course.getDescription());
        return courseDetails;
    }

    private List<CourseDetails> mapCourseListToCourseDetailsList(List<Course> courses) {
        List<CourseDetails> courseDetails = new ArrayList<>();
        courses.forEach(course -> {
            courseDetails.add(mapCourseToCourseDetails(course));
        });
        return courseDetails;
    }
}
