package org.bootapp.model;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "User infomation model")
public class User {	
	
	@ApiModelProperty(value = "Unique identifier representing a specific product for a given latitude & longitude. For example,"
			+ " uberX in San Francisco will have a different product_id than uberX in Los Angeles", required=false)
	private Long id; 

	@ApiModelProperty(value = "Lower bound of the estimated price", required=true,example="testName")
	private String name;
	
	public Long getId() {
		return id;
	}
	
	
	public void setId(Long id) {
		this.id = id;
	}
	
	
	 //@JsonProperty("xxxName")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}  
}
