package org.bootapp.utilities.jmockit.test;

import java.net.URI;

import org.bootapp.util.CommonUtil;

public class CompositeFunctionClass {
	private BasedFunctionClass basedFunctionClass = null;
    
	public CompositeFunctionClass(BasedFunctionClass basedFunctionClass)
	{
		this.basedFunctionClass = basedFunctionClass;
	}
	
	public BasedFunctionClass getBasedFunctionClass() {
		return basedFunctionClass;
	}

	public void setBasedFunctionClass(BasedFunctionClass basedFunctionClass) {
		this.basedFunctionClass = basedFunctionClass;
	}
	
	public String compositeFunction(String info)
	{
		if( null == basedFunctionClass)
			return null;
		return basedFunctionClass.basedFunction(info);
	}
	
	public void printInfo()
	{
		CommonUtil.printTestInfo();
	}
	
	public void printGetingInfo(URI uri)
	{
		String value = CommonUtil.getInfo(uri, String.class);
		System.out.println(value);
	}
}
