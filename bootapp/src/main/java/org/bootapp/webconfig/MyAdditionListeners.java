package org.bootapp.webconfig;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.boot.context.web.SpringBootServletInitializer;

import se.jiderhamn.classloader.leak.prevention.ClassLoaderLeakPreventor;

public class MyAdditionListeners extends SpringBootServletInitializer {
	
	@Override
    public void onStartup(ServletContext servletContext) throws ServletException {
		servletContext.addListener(new ClassLoaderLeakPreventor());
    }
}
