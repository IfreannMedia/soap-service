package com.ifreann.soap.webservices.soapservice.soap;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfig {

    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext context) {
        MessageDispatcherServlet msgDispatcher = new MessageDispatcherServlet();
        msgDispatcher.setApplicationContext(context);
        msgDispatcher.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(msgDispatcher, "/ws/*");
    }

    @Bean(name = "courses")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema courseSchema) {
        DefaultWsdl11Definition defaultWsdl11Definition = new DefaultWsdl11Definition();
        defaultWsdl11Definition.setPortTypeName("CoursePort");
        defaultWsdl11Definition.setTargetNamespace("http://ifreann.com/courses");
        defaultWsdl11Definition.setLocationUri("/ws");
        defaultWsdl11Definition.setSchema(courseSchema);
        return defaultWsdl11Definition;
    }

    @Bean
    public XsdSchema courseSchema() {
        return new SimpleXsdSchema(new ClassPathResource("course-details.xsd"));
    }
}
