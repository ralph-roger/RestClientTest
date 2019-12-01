package com.example.httpclient.objects;

import com.google.api.client.util.Key;

public class View {
	@Key
	private String value;
	@Key
	private String representation;
	@Key
	Expandable expandable;

	// Getter Methods

	public String getValue() {
		return value;
	}

	public String getRepresentation() {
		return representation;
	}

	public Expandable get_expandable() {
		return expandable;
	}

	// Setter Methods

	public void setValue(String value) {
		this.value = value;
	}

	public void setRepresentation(String representation) {
		this.representation = representation;
	}

	public void set_expandable(Expandable _expandableObject) {
		this.expandable = _expandableObject;
	}
}