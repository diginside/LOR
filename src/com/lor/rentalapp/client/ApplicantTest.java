package com.lor.rentalapp.client;

import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.client.ClientConfig;

import com.lor.rentalapp.entity.Applicant;

public class ApplicantTest {
	
	public static void main(String[] args) {
	  ClientConfig config = new ClientConfig();
	  Client client = ClientBuilder.newClient(config);
	  
	  WebTarget target = client.target(getBaseURI());
	 
	  /*
	  //Get XML
	  String xmlResponse = target.path("rest").
			  						 path("applicant").
			  						 request().
			  						 accept(MediaType.TEXT_XML).
			  						 get(String.class);
		  						 
	  //Get XML for application
	  String xmlAppResponse = target.path("rest").
				 					 path("applicant").
				 					 request().
				 					 accept(MediaType.APPLICATION_XML).
				 					 get(String.class);
	  
	  System.out.println(xmlResponse);
	  System.out.println(xmlAppResponse);
	  System.out.println(jsonAppResponse);
	  */
	  /*
	  //Get JSON for application
	  config.register(JacksonFeatures.class);
	  String jsonAppResponse = target.path("rest").
				 					 path("applicant").
				 					 request().
				 					 accept(MediaType.APPLICATION_JSON).
				 					 get(String.class);
	  */
	  
	  Applicant a = new Applicant("4", "hwang19@yahoo.com");
	  Response rsp = target.path("rest").
			  				path("applicants").
			  				path(a.getId()).
			  				request(MediaType.APPLICATION_XML).
			  				put(Entity.entity(a, MediaType.APPLICATION_XML), Response.class);
	  
	  //return code should be 201
	  System.out.println(rsp.getStatus());
	  System.out.println(target.path("rest").
			  					path("applicants").
			  					request().
			  					accept(MediaType.TEXT_XML).
			  					get(String.class));
	  System.out.println(target.path("rest").
								path("applicants").
								request().
								accept(MediaType.APPLICATION_XML).
								get(String.class));
	  
	  //Get applicant with id 1
	  Response delRsp = target.path("rest").
			  				   path("applicants").
			  				   request().
			  				   accept(MediaType.APPLICATION_XML).
			  				   get();
	  
	  //Delete applicant with id 1
	  target.path("rest").path("applicants").request().delete();
	  System.out.println(target.path("rest").
				path("applicants").
				request().
				accept(MediaType.APPLICATION_XML).
				get(String.class));	  
	  
	  //Create a new applicant with id 1.
	  Form form = new Form();
	  form.param("id", "1");
	  form.param("email", "lyhb64@gmail.com");
	  rsp = target.path("rest").
				   path("applicants").
				   request().
				   put(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED), Response.class);
	  
	  System.out.println(rsp.getStatus());
	  System.out.println(target.path("rest").
								path("applicants").
								request().
								accept(MediaType.APPLICATION_XML).
								get(String.class));		  
	  
	  
	  
	}

	private static URI getBaseURI() {
	  return UriBuilder.fromUri("http://localhost:8080/rentalapp").build();	
	}
}
