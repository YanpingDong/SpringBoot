package org.bootapp.utilities.jmockit.test;

import mockit.Injectable;
import mockit.NonStrictExpectations;
import mockit.Tested;
import mockit.Verifications;

import org.junit.Test;

public class CompositeFunctionClassUseAnnotationTest {
	
	@Tested
	private CompositeFunctionClass compositeFunctionClass;
	
	@Injectable
	private BasedFunctionClass basedFunctionClass;
	
	@Test
	public void testCompositeFunction() {
		
		new NonStrictExpectations(basedFunctionClass) {
			{
				basedFunctionClass.basedFunction("info");
				returns("hi info");
			}
		};
		
		System.out.println(compositeFunctionClass.compositeFunction("info"));
		
		new Verifications() {
			{
				basedFunctionClass.basedFunction("info");
				times = 1;
			}
		};
	}
}
