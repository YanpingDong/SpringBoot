package org.bootapp.model;

import org.hibernate.validator.constraints.NotBlank;

public class IdObject {
	@NotBlank(message = "id not null")
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
