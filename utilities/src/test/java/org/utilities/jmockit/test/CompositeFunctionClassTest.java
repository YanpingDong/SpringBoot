package org.utilities.jmockit.test;

import mockit.*;

import org.junit.Test;

public class CompositeFunctionClassTest {

	@Test
	public void testCompositeFunction() {
		final BasedFunctionClass basedFunctionClass = new BasedFunctionClass();
		
		new Expectations(basedFunctionClass) {
			{
				basedFunctionClass.basedFunction("info");
				result="hi info";
			}
		};
		
		CompositeFunctionClass compositeFunctionClass = new CompositeFunctionClass();
		compositeFunctionClass.setBasedFunctionClass(basedFunctionClass);
		System.out.println(compositeFunctionClass.compositeFunction("info"));
		
		new Verifications() {
			{
				basedFunctionClass.basedFunction("info");
				times = 1;
			}
		};
	}

}
