package com.ifreann.soap.webservices.soapservice.exception;

import org.springframework.ws.soap.server.endpoint.annotation.FaultCode;
import org.springframework.ws.soap.server.endpoint.annotation.SoapFault;

@SoapFault(faultCode = FaultCode.CLIENT)
public class CourseNotFoundException extends Throwable {


    private static final long serialVersionUID = 184555103273720563L;

    public CourseNotFoundException(String message) {
        super(message);
    }
}
