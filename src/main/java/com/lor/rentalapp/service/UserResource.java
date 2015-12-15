package com.lor.rentalapp.service;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.hibernate.Session;

import com.lor.rentalapp.dao.HibernateUtil;
import com.lor.rentalapp.entity.User;

@Path("/user")
public class UserResource {
	
	@POST
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void newUser(@FormParam("userName") String userLogin,
						@FormParam("userPassword") String userPassword,
						@FormParam("email") String email,
						@FormParam("firstName") String firstName,
						@FormParam("lastName") String lastName,
						@Context HttpServletResponse servletResponse) throws IOException {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		session.getTransaction().begin();
		
		User user = new User(userLogin, email);
		user.setUserPassword(userPassword);
		if (firstName != null) {
			user.setFirstName(firstName);
		}
		if (lastName != null) {
			user.setLastName(lastName);
		}
		session.save(user);
		
		session.getTransaction().commit();
		
		servletResponse.sendRedirect("./sign_up.html");
	}

}
