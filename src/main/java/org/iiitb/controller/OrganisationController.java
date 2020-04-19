package org.iiitb.controller;

import org.iiitb.bean.Organisation;
import org.iiitb.bean.Student;
import org.iiitb.service.OrganisationService;
import org.iiitb.service.impl.OrganisationServiceImpl;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Path("/organisation")
public class OrganisationController {

    @GET
    @Path("/getOrganisations")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOrganisationList(){
        System.out.println("I'm here...................");
        OrganisationService organisationService = new OrganisationServiceImpl();
        List<Organisation> organisationList = organisationService.findAll();
        if (organisationList == null)
            return Response.noContent().build();
        System.out.println("returned.....");
        return Response.ok().entity(organisationList).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStudentList(@PathParam("id") String oID){
        System.out.println(oID + "......................");
        OrganisationService organisationService = new OrganisationServiceImpl();
        Organisation organisation = organisationService.find(Integer.parseInt(oID));


        Set<Student> studentSet = organisation.getOffer().getAppliedStudents();

        List<Student> studentList = new ArrayList<Student>(studentSet);
        if (studentList == null)
            return Response.noContent().build();
        return Response.ok().entity(studentList).build();
    }
}
