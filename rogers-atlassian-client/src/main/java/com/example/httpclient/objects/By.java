package com.example.httpclient.objects;

import com.google.api.client.util.Key;

public class By {
	@Key
	private String type;
	@Key
	private String username;
	@Key
	private String userKey;
	@Key
	private String displayName;
	@Key
	Expandable expandable;

	// Getter Methods

	public String getType() {
		return type;
	}

	public String getUsername() {
		return username;
	}

	public String getUserKey() {
		return userKey;
	}

	public String getDisplayName() {
		return displayName;
	}

	public Expandable get_expandable() {
		return expandable;
	}

	// Setter Methods

	public void setType(String type) {
		this.type = type;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setUserKey(String userKey) {
		this.userKey = userKey;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public void set_expandable(Expandable expandableObject) {
		this.expandable = expandableObject;
	}
}