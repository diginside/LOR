package com.lor.rentalapp.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.lor.rentalapp.dao.HibernateUtil;

public class HibernateListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext context = sce.getServletContext();
		
		context.setAttribute("sessionFactory", HibernateUtil.getSessionFactory());
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		HibernateUtil.getSessionFactory().close();;
	}
}
