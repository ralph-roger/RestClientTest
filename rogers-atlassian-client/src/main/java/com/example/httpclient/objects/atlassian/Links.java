package com.example.httpclient.objects.atlassian;

import com.google.api.client.util.Key;

public class Links {
	
	@Key
	private String collection;
	@Key
	private String self;
	@Key
	private String base;
	@Key
	private String context;

	// Getter Methods

	public String getSelf() {
		return self;
	}

	public String getBase() {
		return base;
	}

	public String getContext() {
		return context;
	}

	// Setter Methods

	public void setSelf(String self) {
		this.self = self;
	}

	public void setBase(String base) {
		this.base = base;
	}

	public void setContext(String context) {
		this.context = context;
	}
}