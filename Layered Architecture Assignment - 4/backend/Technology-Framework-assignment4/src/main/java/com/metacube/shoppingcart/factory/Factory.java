package com.metacube.shoppingcart.factory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * The Class Factory.
 * 
 * @author Neel Singhal
 */
public class Factory {

	static ApplicationContext applicationContext;

	static {
		applicationContext = new ClassPathXmlApplicationContext(
				"WEB-INF/ApplicationContext.xml");
	}

	/**
	 * Gets the application context.
	 *
	 * @return the application context
	 */
	static public ApplicationContext getApplicationContext() {
		return applicationContext;
	}
}