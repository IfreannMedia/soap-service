package com.ifreann.soap.webservices.soapservice;

import org.springframework.ws.server.endpoint.annotation.Endpoint;

@Endpoint
public class CourseDetailsEndpoint {

    public GetCourseDetailsResponse processCounrseDetailsRequest(GetCourseDetailsRequest request) {
        GetCourseDetailsResponse response = new GetCourseDetailsResponse();
        return response;
    }
}
