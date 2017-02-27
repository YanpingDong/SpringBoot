package org.bootapp.service;

import mockit.Expectations;

import org.bootapp.exception.handle.MyException;
import org.bootapp.utilities.jmockit.test.BasedFunctionClass;
import org.bootapp.utilities.jmockit.test.CompositeFunctionClass;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.test.config.service.TestServiceSpringConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TestServiceSpringConfig.class)
public class ForTestServiceTest {

	@Autowired
	private ForTestService fortestService;
	
	@Test
	public void getUserInfo()
	{
		try {
			System.out.println(fortestService.getInfo(1));
		} catch (MyException e) {
			//if don't get normal user info, test fail 
			Assert.fail();
			e.printStackTrace();
		}
	}
	
	@Test
	public void getNonexistentUserInfo()
	{
		try {
			fortestService.getInfo(0);
		} catch (MyException e) {
			//whether or not match our expectation
			Assert.assertTrue( "Didn't find user by 0".equalsIgnoreCase(e.getMessage()) );
		}
	}
	
	/**
	 * test for spring SpringJUnit4ClassRunner compliance. If JMockit can be worked with SpringJUnit4ClassRunner
	 * 
	 * result: work well and "JMockit coverage report" can be used to report test related with spring framwork and
	 *         "JMockit coverage report" will auto create a directory named "coverage-report" in project work directory 
	 *         
	 * "cobertura test coverage report" also can be used to report the test write with JMockit -- 
	 *  Run mvn cobertura:cobertura surefire-report:report and then you will find cobertura in /target/site.
	 */
	@Test
	public void testCompositeFunction() {
		final BasedFunctionClass basedFunctionClass = new BasedFunctionClass();
		
		new Expectations(basedFunctionClass) {
			{
				basedFunctionClass.basedFunction("info");
				result = "hi info";
			}
		};
		
		CompositeFunctionClass compositeFunctionClass = new CompositeFunctionClass(basedFunctionClass);
		System.out.println(compositeFunctionClass.compositeFunction("info"));
		
	}
}
