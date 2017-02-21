package org.bootapp.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;


@ApiModel(description = "")
public class User {
	private Long id; 
	private String name;
	@ApiModelProperty(value = "Unique identifier representing a specific product for a given latitude & longitude. For example,"
			+ " uberX in San Francisco will have a different product_id than uberX in Los Angeles", required=true)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	 @ApiModelProperty(value = "Lower bound of the estimated price.",required=false)
	 @JsonProperty("xxxName")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}  
}
