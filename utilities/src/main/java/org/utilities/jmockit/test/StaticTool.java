package org.utilities.jmockit.test;

public class StaticTool {
	
	public static String translate(String key)
	{
		if(null != key)
			return key;
		return null;
	}
	
	public static String compositeInfo(String value)
	{
		if(null != value)
			return translate(value) + " " + value;
		return null;
	}
}
