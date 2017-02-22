package org.bootapp.util;

import java.net.URI;

public class CommonUtil {
	public static void printTestInfo()
	{
		System.out.println("test info");
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T getInfo(URI uri, Class<T> type)
	{
	   return (T) uri.toString();
	}
}
