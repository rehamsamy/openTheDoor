package com.openthedoor.pojo;

import java.util.List;
import com.google.gson.annotations.SerializedName;


public class ItemItem{

	@SerializedName("item")
	private List<ItemItem> item;

	@SerializedName("name")
	private String name;

	@SerializedName("_postman_isSubFolder")
	private boolean postmanIsSubFolder;

	@SerializedName("request")
	private Request request;

	@SerializedName("response")
	private List<Object> response;

	public void setItem(List<ItemItem> item){
		this.item = item;
	}

	public List<ItemItem> getItem(){
		return item;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setPostmanIsSubFolder(boolean postmanIsSubFolder){
		this.postmanIsSubFolder = postmanIsSubFolder;
	}

	public boolean isPostmanIsSubFolder(){
		return postmanIsSubFolder;
	}

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

	@Override
 	public String toString(){
		return 
			"ItemItem{" + 
			"item = '" + item + '\'' + 
			",name = '" + name + '\'' + 
			",_postman_isSubFolder = '" + postmanIsSubFolder + '\'' + 
			",request = '" + request + '\'' + 
			",response = '" + response + '\'' + 
			"}";
		}
}