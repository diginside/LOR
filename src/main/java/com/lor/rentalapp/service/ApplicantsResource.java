package com.lor.rentalapp.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
//import javax.websocket.server.PathParam; - Make sure you don't import this wrong class here.
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import org.hibernate.Session;

import com.lor.rentalapp.dao.ApplicantDao;
import com.lor.rentalapp.dao.DateTimeUtil;
import com.lor.rentalapp.dao.HibernateUtil;
import com.lor.rentalapp.entity.Applicant;

@Path("/applicants")
public class ApplicantsResource {
	
	@Context
	UriInfo uriInfo;
	@Context
	Request request;
	
	@GET
	@Produces(MediaType.TEXT_XML)
	public List<Applicant> getApplicantsBrowser() {
		List<Applicant> applicants = new ArrayList<Applicant>();
		applicants.addAll(ApplicantDao.instance.getModel().values());
		
		return applicants;
	}
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Applicant> getApplicants() {
		List<Applicant> applicants = new ArrayList<Applicant>();
		applicants.addAll(ApplicantDao.instance.getModel().values());
		
		return applicants;
	}

	// returns the number of applicants 
	//use http://localhost:8080/rentalapp/rest/applicants/count
	@GET
	@Path("count")
	@Produces(MediaType.TEXT_PLAIN)
	public String getCount() {
	  int count = ApplicantDao.instance.getModel().size();
	  
	  return String.valueOf(count);
	}
	
	@POST
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void newApplicant(@FormParam("firstName") String firstName,
							 @FormParam("midName") String midName,
							 @FormParam("lastName") String lastName,
							 @FormParam("ssNum") String ssNum,
							 @FormParam("birthDate") String birthDate,
							 @FormParam("dlNum") String dlNum,
							 @FormParam("dlState") String dlState,
							 @FormParam("email") String email,
							 @FormParam("homePhone") String homePhone,
							 @FormParam("mobilePhone") String mobilePhone,
							 @Context HttpServletResponse servletResponse) throws IOException {

	  //ApplicantDao.instance.getModel().put(email, applicant);
	  Session session = HibernateUtil.getSessionFactory().openSession();
	  session.getTransaction().begin();
	  
	  Applicant applicant = new Applicant(email, mobilePhone);
	  applicant.setFirstName(firstName);
	  applicant.setMidName(midName);
	  applicant.setLastName(lastName);
	  if( ssNum != null ) {
		applicant.setSsNum(ssNum);
	  }
	  applicant.setBirthDate(DateTimeUtil.toDateFormat(birthDate));
	  applicant.setDlNum(dlNum);
	  applicant.setDlState(dlState);
	  applicant.setHomePhone(homePhone);
	  
	  session.save(applicant);
	  session.getTransaction().commit();
	  
	  servletResponse.sendRedirect("../new_applicant.html");
	}
	
	// Defines that the path parameter after applicants is treated as a parameter and passed
	// to the ApplicantResource.
	// i.e. http://localhost:8080/rentalapp/rest/applicants/1 
	@Path("{applicant}")
	public ApplicantResource getApplicant(@PathParam("applicant") String id) {
		System.out.println("The applicant id = " + id);
		return new ApplicantResource(uriInfo, request, id);
	}
}
