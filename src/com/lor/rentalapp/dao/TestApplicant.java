package com.lor.rentalapp.dao;

import org.hibernate.Session;

import com.lor.rentalapp.entity.Applicant;

public class TestApplicant {
	
	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.getTransaction().begin();
		
		
		  Applicant applicant = new Applicant("hwang19@yahoo.com", "7708274860");
		  applicant.setFirstName("hong");
		  applicant.setMidName("");
		  applicant.setLastName("Wang");
		  //if( ssNum != null ) {
			applicant.setSsNum("123432424");
		  //}
		  //applicant.setBirthDate("12/4/1945");
		  applicant.setDlNum("324234124");
		  applicant.setDlState("GA");
		  applicant.setHomePhone("2123131234");
		  
		  session.save(applicant);
		  
		  session.getTransaction().commit();
		
	}

}
