package org.utilities.jmockit.test;

public class CompositeFunctionClass {
	private BasedFunctionClass basedFunctionClass = null;

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
}
