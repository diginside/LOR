package com.lor.rentalapp.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class Hello {
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayPlainTextHello() {
		return "Hello from Lord of Rent";
	}
	
	@GET
	@Produces(MediaType.TEXT_XML)
	public String sayXMLHello() {
		return "<?xml version=\"1.0\"?>" + "<hello>Hello from Lord of Rent" + "</hello>";
	}
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String sayHtmlHello() {
		return "<html>" + "<title>" + "Hello from Lord of Rent" + "</title>"
				+ "<body><h1>" + "Hello from Lord of Rent" + "</h1></body>"
				+ "</html>";
				
	}

}
