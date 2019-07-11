package com.openthedoor.pojo;

import java.util.List;
import com.google.gson.annotations.SerializedName;


public class Messages{

	@SerializedName("phone")
	private List<String> phone;

	@SerializedName("email")
	private List<String> email;

	public void setPhone(List<String> phone){
		this.phone = phone;
	}

	public List<String> getPhone(){
		return phone;
	}

	public void setEmail(List<String> email){
		this.email = email;
	}

	public List<String> getEmail(){
		return email;
	}

	@Override
 	public String toString(){
		return 
			"Messages{" + 
			"phone = '" + phone + '\'' + 
			",email = '" + email + '\'' + 
			"}";
		}
}