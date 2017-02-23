package org.bootapp.utilities.jmockit.test;

import org.junit.Test;

import mockit.Expectations;
import mockit.Verifications;

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
