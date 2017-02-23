package org.bootapp.utilities.jmockit.test;

import java.net.URI;
import java.net.URISyntaxException;

import org.bootapp.util.CommonUtil;
import org.junit.Test;

import mockit.Deencapsulation;
import mockit.Expectations;
import mockit.Injectable;
import mockit.Tested;
import mockit.Verifications;

public class CompositeFunctionClassUseAnnotationTest {
	
	@Tested
	private CompositeFunctionClass compositeFunctionClass;
	
	@Injectable
	private BasedFunctionClass basedFunctionClass;
	
//	@Before
//	public void setUp() throws Exception {
//		new MockUp<CommonUtil>(){
//			@Mock
//			public void $clinit()
//			{
//			}
//		 
//			@Mock
//			public void printTestInfo()
//			{
//				System.out.println("mock info");
//			}
//		};
//	}
	
	@Test
	public void testCompositeFunction() {
		 
		new Expectations(basedFunctionClass) {
			{
				basedFunctionClass.basedFunction("info");
				result ="hi info";
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		compositeFunctionClass.printGetingInfo(uri);
	}
}
