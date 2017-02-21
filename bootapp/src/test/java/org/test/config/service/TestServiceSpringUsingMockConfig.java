package org.test.config.service;

import org.bootapp.dao.ForTestDaoImpStub;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@EnableAutoConfiguration
/**
 * The following two "Component scan " ways are both right. 
 * way 1: the first can be use in situation that less classes need to be tested
 * way 2: the second can be use in situation that have more classes to be tested
 */
//way 1
@ComponentScan(basePackages="org.bootapp",useDefaultFilters=true,
               excludeFilters={@ComponentScan.Filter(type=FilterType.ASSIGNABLE_TYPE, value = {ForTestDaoImpStub.class}) })
//way 2 
/*@ComponentScan(basePackages={"org.bootapp.dao", "org.bootapp.service"},useDefaultFilters=true,
               excludeFilters={@ComponentScan.Filter(type=FilterType.ASSIGNABLE_TYPE, value = {ForTestDaoImp.class}) } )*/
public class TestServiceSpringUsingMockConfig {

}
