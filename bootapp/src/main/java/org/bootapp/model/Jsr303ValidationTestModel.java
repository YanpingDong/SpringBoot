package org.bootapp.model;

import org.bootapp.validator.constraints.CompositeObjectNotEmpty;
import org.hibernate.validator.constraints.NotBlank;


public class Jsr303ValidationTestModel extends IdObject{
	
	@NotBlank(message="this info cann't be null")  
	private String notNullInfo;

	@CompositeObjectNotEmpty
	private CompositeObjectData compsiteObject;
	
	public CompositeObjectData getCompsiteObject() {
		return compsiteObject;
	}

	public void setCompsiteObject(CompositeObjectData compsiteObject) {
		this.compsiteObject = compsiteObject;
	}

	public String getNotNullInfo() {
		return notNullInfo;
	}

	public void setNotNullInfo(String notNullInfo) {
		this.notNullInfo = notNullInfo;
	} 
}
