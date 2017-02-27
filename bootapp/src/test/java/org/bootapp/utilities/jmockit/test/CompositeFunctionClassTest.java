package org.bootapp.utilities.jmockit.test;

import mockit.Expectations;

import org.junit.Test;

public class CompositeFunctionClassTest {

	@Test
	public void testCompositeFunction() {
		final BasedFunctionClass basedFunctionClass = new BasedFunctionClass();
		
		new Expectations(basedFunctionClass) {
			{
				basedFunctionClass.basedFunction("info");
				result = "hi info";
			}
		};
		
		CompositeFunctionClass compositeFunctionClass = 
				new CompositeFunctionClass(basedFunctionClass);
		//compositeFunctionClass.setBasedFunctionClass(basedFunctionClass);
		System.out.println(compositeFunctionClass.compositeFunction("info"));
		
	}

}
