package com.example.httpclient.search;
import java.util.List;

import com.google.api.client.util.Key;

public class SearchResults {
	@Key
	private List<Result> results;

	public List<Result> getResults() {
		return results;
	}

	public void setResults(List<Result> results) {
		this.results = results;
	}
}
