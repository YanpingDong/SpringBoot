package org.bootapp.utilities.jmockit.test;

import java.net.URI;
import java.net.URISyntaxException;

import mockit.Deencapsulation;
import mockit.Expectations;
import mockit.Injectable;
import mockit.Tested;
import mockit.Verifications;

import org.bootapp.util.CommonUtil;
import org.junit.Test;

public class CompositeFunctionClassUseAnnotationTest {
	
	@Tested
	private CompositeFunctionClass compositeFunctionClass;
	
	
	@Injectable 
	private BasedFunctionClass basedFunctionClass;
	
	@Test
	public void testPrintInfo()
	{
		new Expectations(CommonUtil.class)
		{
			{
				Deencapsulation.invoke(CommonUtil.class, "printTestInfo"); 
			}	
		};
		compositeFunctionClass.printInfo();
	}
	
	@Test
	public void testCompositeFunction() {
		
		new Expectations(basedFunctionClass) {
			{
				basedFunctionClass.basedFunction(anyString);
				result ="hi info";
				times = 1;
			}
		};
		
		System.out.println(compositeFunctionClass.compositeFunction("info")+" test composite function");
		
        new Verifications(){{

        	basedFunctionClass.basedFunction(anyString);times = 1;
        	
        }};
	}
	
	@Test
	public void testprintGetingInfo()
	{
		new Expectations(CommonUtil.class)
		{
			{
				try
				{
					URI uri = new URI("www.dyp.com");
					CommonUtil.getInfo(uri, String.class);
		            result = "you are viewing site www.dyp.com";  
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
			}	
		};
		
		URI uri = null;
		try {
			uri = new URI("www.dyp.com");
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		compositeFunctionClass.printGetingInfo(uri);
		
	}
}
