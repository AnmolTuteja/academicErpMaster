package org.iiitb.controller;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.iiitb.bean.Student;
import org.iiitb.service.EmployeeService;
import org.iiitb.service.impl.EmployeeServiceImpl;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;

@Path("/employee")
public class EmployeeController {

    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.TEXT_PLAIN)
    public Response validateEmployee(@FormDataParam("email") String userName,
                               @FormDataParam("password") String password) throws URISyntaxException {

        EmployeeService employeeService = new EmployeeServiceImpl();
        if(employeeService.validateEmployee(userName, password) == true){
            return Response.seeOther(new URI("/academic_erp_war_exploded/companyList.html")).build();
        } else return null;

    }
}
