package com.openthedoor.pojo;

import java.util.List;
import com.google.gson.annotations.SerializedName;


public class Url{

	@SerializedName("path")
	private List<String> path;

	@SerializedName("protocol")
	private String protocol;

	@SerializedName("query")
	private List<QueryItem> query;

	@SerializedName("host")
	private List<String> host;

	@SerializedName("raw")
	private String raw;

	public void setPath(List<String> path){
		this.path = path;
	}

	public List<String> getPath(){
		return path;
	}

	public void setProtocol(String protocol){
		this.protocol = protocol;
	}

	public String getProtocol(){
		return protocol;
	}

	public void setQuery(List<QueryItem> query){
		this.query = query;
	}

	public List<QueryItem> getQuery(){
		return query;
	}

	public void setHost(List<String> host){
		this.host = host;
	}

	public List<String> getHost(){
		return host;
	}

	public void setRaw(String raw){
		this.raw = raw;
	}

	public String getRaw(){
		return raw;
	}

	@Override
 	public String toString(){
		return 
			"Url{" + 
			"path = '" + path + '\'' + 
			",protocol = '" + protocol + '\'' + 
			",query = '" + query + '\'' + 
			",host = '" + host + '\'' + 
			",raw = '" + raw + '\'' + 
			"}";
		}
}