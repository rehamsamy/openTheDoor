package com.openthedoor.pojo;

import java.util.List;
import com.google.gson.annotations.SerializedName;


public class Request{

	@SerializedName("method")
	private String method;

	@SerializedName("header")
	private List<Object> header;

	@SerializedName("url")
	private Url url;

	public void setMethod(String method){
		this.method = method;
	}

	public String getMethod(){
		return method;
	}

	public void setHeader(List<Object> header){
		this.header = header;
	}

	public List<Object> getHeader(){
		return header;
	}

	public void setUrl(Url url){
		this.url = url;
	}

	public Url getUrl(){
		return url;
	}

	@Override
 	public String toString(){
		return 
			"Request{" + 
			"method = '" + method + '\'' + 
			",header = '" + header + '\'' + 
			",url = '" + url + '\'' + 
			"}";
		}
}