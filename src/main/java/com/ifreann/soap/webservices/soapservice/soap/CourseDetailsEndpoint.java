package com.ifreann.soap.webservices.soapservice.soap;

import com.ifreann.soap.webservices.soapservice.CourseDetails;
import com.ifreann.soap.webservices.soapservice.GetCourseDetailsRequest;
import com.ifreann.soap.webservices.soapservice.GetCourseDetailsResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class CourseDetailsEndpoint {

    @PayloadRoot(namespace = "http://ifreann.com/courses", localPart = "GetCourseDetailsRequest")
    @ResponsePayload
    public GetCourseDetailsResponse processCourseSDetailsRequest(@RequestPayload GetCourseDetailsRequest request) {
        GetCourseDetailsResponse response = new GetCourseDetailsResponse();
        CourseDetails courseDetails = new CourseDetails();
        courseDetails.setId(request.getId());
        courseDetails.setName("Microservices Course");
        courseDetails.setDescription("Micro up your services");

        response.setCourseDetails(courseDetails);
        return response;
    }
}
