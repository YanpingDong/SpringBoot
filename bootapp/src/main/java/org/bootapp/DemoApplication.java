package org.bootapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.utilities.config.EnableApiDoc;

@PropertySource( ignoreResourceNotFound=false,value = { "classpath:application.properties" })
@ComponentScan(basePackages="org.bootapp")
@EnableAutoConfiguration
@SpringBootApplication(scanBasePackages="org.bootapp") //Can be used to replace the above three lines 
@EnableApiDoc  //self created annotation for start swagger
public class DemoApplication implements EmbeddedServletContainerCustomizer
{
	@Value("${port}")
	int port;
	
	@Value("${contextPath}")
	String contextPath;
	private static Logger LOG = 
			LoggerFactory.getLogger(DemoApplication.class);
	
	public static void main(String[] args)  {
		LOG.debug("=============for logback configuration test============");
		SpringApplication.run(DemoApplication.class, args);

		/*EventListenerMethodProcessor emp;
		emp = new EventListenerMethodProcessor();
		emp.afterSingletonsInstantiated();*/
	}
	@Override
	public void customize(ConfigurableEmbeddedServletContainer container) {
		container.setPort(port); 
		container.setContextPath(contextPath);
	}
}
