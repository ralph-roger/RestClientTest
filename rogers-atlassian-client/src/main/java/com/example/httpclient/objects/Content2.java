package com.example.httpclient.objects;
import java.util.ArrayList;

import com.google.api.client.util.Key;

public class Content2 {
	@Key
	private String id;
	@Key
	private String type;
	@Key
	private String status;
	@Key
	private String title;
	@Key
	Space space;
	@Key
	Version version;
	@Key
	ArrayList<Object> ancestors = new ArrayList<Object>();
	@Key
	ArrayList<Object> operations = new ArrayList<Object>();
	@Key
	Children children;
	@Key
	Descendants descendants;
	@Key
	Container container;
	@Key
	Body BodyObject;
	@Key
	Metadata metadata;
	@Key
	Restrictions restrictions;
	@Key
	Links links;

	// Getter Methods

	public String getId() {
		return id;
	}

	public String getType() {
		return type;
	}

	public String getStatus() {
		return status;
	}

	public String getTitle() {
		return title;
	}

	public Space getSpace() {
		return space;
	}

	public Version getVersion() {
		return version;
	}

	public Children getChildren() {
		return children;
	}

	public Descendants getDescendants() {
		return descendants;
	}

	public Container getContainer() {
		return container;
	}

	public Body getBody() {
		return BodyObject;
	}

	public Metadata getMetadata() {
		return metadata;
	}

	public Restrictions getRestrictions() {
		return restrictions;
	}

	public Links getLinks() {
		return links;
	}

	// Setter Methods

	public void setId(String id) {
		this.id = id;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setSpace(Space spaceObject) {
		this.space = spaceObject;
	}

	public void setVersion(Version versionObject) {
		this.version = versionObject;
	}

	public void setChildren(Children childrenObject) {
		this.children = childrenObject;
	}

	public void setDescendants(Descendants descendantsObject) {
		this.descendants = descendantsObject;
	}

	public void setContainer(Container containerObject) {
		this.container = containerObject;
	}

	public void setBody(Body bodyObject) {
		this.BodyObject = bodyObject;
	}

	public void setMetadata(Metadata metadataObject) {
		this.metadata = metadataObject;
	}

	public void setRestrictions(Restrictions restrictionsObject) {
		this.restrictions = restrictionsObject;
	}

	public void setLinks(Links linksObject) {
		this.links = linksObject;
	}
}


