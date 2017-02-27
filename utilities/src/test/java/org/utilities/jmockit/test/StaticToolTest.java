package org.utilities.jmockit.test;

import static org.junit.Assert.*;
import mockit.Expectations;
import mockit.Verifications;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StaticToolTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		new Expectations(StaticTool.class){
			{
				StaticTool.translate(anyString);
				result = "Hello";
			}
			
		};
		
		System.out.println(StaticTool.compositeInfo("good"));
		
		new Verifications() {
			{
				StaticTool.translate(anyString);
				times = 1;
			}
		};
	}

}
