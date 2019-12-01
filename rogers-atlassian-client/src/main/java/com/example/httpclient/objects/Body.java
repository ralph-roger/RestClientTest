package com.example.httpclient.objects;

import com.google.api.client.util.Key;

public class Body {
	@Key
	View view;

	// Getter Methods

	public View getView() {
		return view;
	}

	// Setter Methods

	public void setView(View viewObject) {
		this.view = viewObject;
	}
}