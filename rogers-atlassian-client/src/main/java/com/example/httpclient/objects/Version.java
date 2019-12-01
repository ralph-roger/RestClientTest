package com.example.httpclient.objects;

import com.google.api.client.util.Key;

public class Version {
	@Key
	By ByObject;
	@Key
	private String when;
	@Key
	private String message;
	@Key
	private float number;
	@Key
	private boolean minorEdit;
	@Key
	private boolean hidden;

	// Getter Methods

	public By getBy() {
		return ByObject;
	}

	public String getWhen() {
		return when;
	}

	public String getMessage() {
		return message;
	}

	public float getNumber() {
		return number;
	}

	public boolean getMinorEdit() {
		return minorEdit;
	}

	public boolean getHidden() {
		return hidden;
	}

	// Setter Methods

	public void setBy(By byObject) {
		this.ByObject = byObject;
	}

	public void setWhen(String when) {
		this.when = when;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setNumber(float number) {
		this.number = number;
	}

	public void setMinorEdit(boolean minorEdit) {
		this.minorEdit = minorEdit;
	}

	public void setHidden(boolean hidden) {
		this.hidden = hidden;
	}
}