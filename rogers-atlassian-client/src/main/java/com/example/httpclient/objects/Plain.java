package com.example.httpclient.objects;

import com.google.api.client.util.Key;

public class Plain {
	@Key
	private String value;
	@Key
	private String representation;

	// Getter Methods

	public String getValue() {
		return value;
	}

	public String getRepresentation() {
		return representation;
	}

	// Setter Methods

	public void setValue(String value) {
		this.value = value;
	}

	public void setRepresentation(String representation) {
		this.representation = representation;
	}
}