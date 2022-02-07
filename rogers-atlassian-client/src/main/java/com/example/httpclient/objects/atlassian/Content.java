package com.example.httpclient.objects.atlassian;

import com.google.api.client.util.Key;

public class Content {
	@Key
	private float start;
	@Key
	private float limit;
	@Key
	private float size;
	@Key
	Links linksObject;

	// Getter Methods

	public float getStart() {
		return start;
	}

	public float getLimit() {
		return limit;
	}

	public float getSize() {
		return size;
	}

	public Links get_links() {
		return linksObject;
	}

	// Setter Methods

	public void setStart(float start) {
		this.start = start;
	}

	public void setLimit(float limit) {
		this.limit = limit;
	}

	public void setSize(float size) {
		this.size = size;
	}

	public void set_links(Links _linksObject) {
		this.linksObject = _linksObject;
	}
}
