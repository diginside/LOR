package com.lor.rentalapp.dao;

import java.util.HashMap;
import java.util.Map;

import com.lor.rentalapp.entity.*;

public enum ApplicantDao {
	instance;
	
	private Map<String, Applicant> contentProvider = new HashMap<>();
	
	private ApplicantDao() {
		
		Applicant applicant = new Applicant("1", "test@lordofrent.com");
		applicant.setMobilePhone("7708274860");
		contentProvider.put("1", applicant);
		
		applicant = new Applicant("2", "admin@lordofrent.com");
		applicant.setHomePhone("7705829204");
		contentProvider.put("2", applicant);
			
	}
	
	public Map<String, Applicant> getModel() {
		return contentProvider;
	}

}
