package com.app;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


// dispatcher servlet.
public class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/java-app-web/" };
	}
}
