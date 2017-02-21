package org.bootapp.exception.handle;

public class MyException extends Exception {
	private static final long serialVersionUID = -2614303275247813103L;
	public MyException(String msg) {
		super(msg);
	}

	/**
	 * Constructor for ServletRequestBindingException.
	 * @param msg the detail message
	 * @param cause the root cause
	 */
	public MyException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
