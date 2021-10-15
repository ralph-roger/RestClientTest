package com.example.httpclient.objects;
import java.util.List;

import com.google.api.client.util.Key;

public class Results {
	@Key
	private List<Content2> results;

	public List<Content2> getResults() {
		return results;
	}

	public void setResults(List<Content2> results) {
		this.results = results;
	}
	
	

}
