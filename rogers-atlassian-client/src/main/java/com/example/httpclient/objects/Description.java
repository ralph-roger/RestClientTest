package com.example.httpclient.objects;

import com.google.api.client.util.Key;

public class Description {
	@Key
	Plain plain;

	// Getter Methods

	public Plain getPlain() {
		return plain;
	}

	// Setter Methods

	public void setPlain(Plain plainObject) {
		this.plain = plainObject;
	}
}