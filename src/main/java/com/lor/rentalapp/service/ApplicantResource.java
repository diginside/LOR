package com.lor.rentalapp.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.JAXBElement;

import com.lor.rentalapp.dao.ApplicantDao;
import com.lor.rentalapp.entity.Applicant;

//@Path("/applicant")
public class ApplicantResource {

	/*
	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Applicant getXML() {
	  Applicant applicant = new Applicant();
	  applicant.setId("2145B");
	  applicant.setFirstName("Marissa");
	  applicant.setMidName("X");
	  applicant.setLastName("Matthews");
	  applicant.setEmail("msomething@gmail.com");
	  applicant.setPhone("7702221234");
	
	  return applicant;
	}
	
	@GET
	@Produces({ MediaType.TEXT_XML })
	public Applicant getHTML() {
	  Applicant applicant = new Applicant();
	  applicant.setId("2145B");
	  applicant.setFirstName("Marissa");
	  applicant.setMidName("X");
	  applicant.setLastName("Matthews");
	  applicant.setEmail("msomething@gmail.com");
	  applicant.setPhone("7702221234");
		
	  return applicant;
	}
	*/
	
	@Context
	UriInfo uriInfo;
	@Context
	Request request;
	String id;
	
	public ApplicantResource(UriInfo uriInfo, Request request, String id) {
		this.uriInfo = uriInfo;
		this.request = request;
		this.id = id;
	}
	
	// application integration
	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Applicant getApplicant() {
		System.out.println("The passed id = " + id);
		Applicant applicant = ApplicantDao.instance.getModel().get(id);
		if (applicant == null)
			throw new RuntimeException("Get: Applicant with" + id + " not found");
		return applicant;
	}
	
	
	// for browser
	@GET
	@Produces({ MediaType.TEXT_XML })
	public Applicant getApplicantHTML() {
	  Applicant applicant = ApplicantDao.instance.getModel().get(id);
	  if (applicant == null)
		throw new RuntimeException("Get: Applicant with" + id + " not found");
		
	  return applicant;		
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	public Response putApplicant(JAXBElement<Applicant> applicant) {
	  Applicant a = applicant.getValue();
	  return putAndGetResponse(a);
	}
	
	@DELETE
	public void deleteApplicant() {
	  Applicant a = ApplicantDao.instance.getModel().remove(id);
	  if (a == null)
		throw new RuntimeException("Delete: Applicant with " + id + " not found");
	}

	private Response putAndGetResponse(Applicant applicant) {
	  Response rsp;
	  if( ApplicantDao.instance.getModel().containsKey(applicant.getId()) ) {
		  rsp = Response.noContent().build();
	  } else {
		  rsp = Response.created(uriInfo.getAbsolutePath()).build();
	  }
	  ApplicantDao.instance.getModel().put(applicant.getId(), applicant);
	  
	  return rsp;
	}


}
