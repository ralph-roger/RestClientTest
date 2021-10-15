package com.example.httpclient.search;

import com.google.api.client.util.Key;

public class Result {
	@Key
	private String id;
	@Key
	private String type;
	@Key
	private String status;
	@Key
	private String title;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
}
