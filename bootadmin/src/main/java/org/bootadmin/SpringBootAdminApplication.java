package org.bootadmin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;

import de.codecentric.boot.admin.config.EnableAdminServer;

@Configuration
@EnableAutoConfiguration
@EnableAdminServer
public class SpringBootAdminApplication extends SpringBootServletInitializer {
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringBootAdminApplication.class);
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringBootAdminApplication.class);
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(SpringBootAdminApplication.class, args);
	}
}
