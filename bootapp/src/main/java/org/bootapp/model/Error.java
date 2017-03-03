package org.bootapp.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.servlet.http.HttpServletRequest;

@ApiModel(description = "Uniform error info")
public class Error {
	private String uri;
	private String method;
	private int errorCode;
	private String errorMessage;
	private String moreInfo;
	
	public Error(){};
	
	public Error(HttpServletRequest request,int errorCode,String errorMessage,String moreInfo){
		this.uri = request.getRequestURI();
		this.method = request.getMethod();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.moreInfo = moreInfo;
	}
	
	@ApiModelProperty(value = "invoked uri")
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	
	@ApiModelProperty(value = "invoked method")
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	
	@ApiModelProperty(value = "ErrorCode")
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	
	@ApiModelProperty(value = "ErrorMessage")
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public String getMoreInfo() {
		return moreInfo;
	}
	public void setMoreInfo(String moreInfo) {
		this.moreInfo = moreInfo;
	}


}
