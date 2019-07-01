package com.openthedoor.pojo;

import java.util.List;
import com.google.gson.annotations.SerializedName;


public class LoginResponse{

	@SerializedName("request")
	private Request request;

	@SerializedName("response")
	private List<Object> response;

	@SerializedName("name")
	private String name;

	public void setRequest(Request request){
		this.request = request;
	}

	public Request getRequest(){
		return request;
	}

	public void setResponse(List<Object> response){
		this.response = response;
	}

	public List<Object> getResponse(){
		return response;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	@Override
 	public String toString(){
		return 
			"LoginResponse{" + 
			"request = '" + request + '\'' + 
			",response = '" + response + '\'' + 
			",name = '" + name + '\'' + 
			"}";
		}
}