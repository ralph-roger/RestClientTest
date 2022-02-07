package com.example.httpclient.objects.atlassian;

import com.google.api.client.util.Key;

public class Container {
	@Key
	private float id;
	@Key
	private String key;
	@Key
	private String name;
	@Key
	Description description;
	@Key
	Metadata metadata;
	@Key
	Links links;

	// Getter Methods

	public float getId() {
		return id;
	}

	public String getKey() {
		return key;
	}

	public String getName() {
		return name;
	}

	public Description getDescription() {
		return description;
	}

	public Metadata getMetadata() {
		return metadata;
	}

	public Links get_links() {
		return links;
	}

	// Setter Methods

	public void setId(float id) {
		this.id = id;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(Description descriptionObject) {
		this.description = descriptionObject;
	}

	public void setMetadata(Metadata metadataObject) {
		this.metadata = metadataObject;
	}

	public void set_links(Links linksObject) {
		this.links = linksObject;
	}
}