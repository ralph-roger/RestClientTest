package com.example.httpclient;

import java.util.List;

import com.google.api.client.util.Key;
import com.google.gson.Gson;

public class TestJson2Java4 {

	public static void main(String... args) throws Exception {
		String json = "{'title' : 'Erste Tests mit gson', 'id' : 1, 'children' : 'true', "
				+ "'groups' : [{'name' : 'Reifegerste', 'vname' : 'Ralph-Roger'},"
				+ "{'name' : 'Rössig', 'vname' : 'Ulrike'}]}";

		// Now do the magic.
		Data data = new Gson().fromJson(json, Data.class);

		// Show it.
		System.out.println("Test ---> " + data);
		for (Data1 data1 : data.getGroups()) {
			System.out.println(data1.getVname() + " " + data1.getName());
		}
		String jsonOut = new Gson().toJson(data);
		System.out.println(json + "\n" + jsonOut);

	}

	class Data {
		@Key
		private String title;
		@Key
		private Long id;
		@Key
		private Boolean children;
		@Key
		private List<Data1> groups;

		public String getTitle() {
			return title;
		}

		public Long getId() {
			return id;
		}

		public Boolean getChildren() {
			return children;
		} 

		public List<Data1> getGroups() {
			return groups;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public void setChildren(Boolean children) {
			this.children = children;
		}

		public void setGroups(List<Data1> groups) {
			this.groups = groups;
		}

		public String toString() {
			return String.format("title:%s,id:%d,children:%s,groups:%s", title, id, children, groups);
		}
	}

	class Data1 {
		@Key
		String name;
		@Key
		String vname;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getVname() {
			return vname;
		}

		public void setVname(String vname) {
			this.vname = vname;
		}

		public String toString() {
			return String.format("Name ist " + vname + " " + name);
		}
	}
}
