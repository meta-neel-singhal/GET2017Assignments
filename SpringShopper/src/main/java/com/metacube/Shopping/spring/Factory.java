package com.metacube.Shopping.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Factory {
	
	/** The application context. */
	static ApplicationContext applicationContext;

	static {

applicationContext = new ClassPathXmlApplicationContext("WEB-INF/mvc-dispatcher-servlet.xml");
	}

	/**
	 * Gets the application context.
	 *
	 * @return the application context
	 */
	static public ApplicationContext getApplicationContext()
	{
		return applicationContext;
	}
}
