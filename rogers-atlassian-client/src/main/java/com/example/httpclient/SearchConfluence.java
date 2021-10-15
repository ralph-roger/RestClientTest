package com.example.httpclient;

import java.io.IOException;

import com.example.httpclient.search.Result;
import com.example.httpclient.search.SearchResults;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.gson.Gson;

public class SearchConfluence {

	private static final JsonFactory JSON_FACTORY = new JacksonFactory();

	private static final String TEST_URL = "http://localhost:8090/rest/api/content/search";

	private static HttpTransport TRANSPORT;

	private static HttpRequestFactory REQ_FACTORY;

	private static HttpTransport transport() {
		if (null == TRANSPORT) {
			TRANSPORT = new NetHttpTransport();
		}
		return TRANSPORT;
	}

	private static HttpRequestFactory reqFactory() {
		if (null == REQ_FACTORY) {
			REQ_FACTORY = transport().createRequestFactory();
		}
		return REQ_FACTORY;
	}

	public static void main(String[] args) throws IOException, NoSuchFieldException, SecurityException {
		System.out.println("START");
		
		searchRequestWithQueryParameters();

		System.out.println("ENDE");
	}

	/**
	 * Submit a GET request with query parameters
	 *
	 * @throws IOException
	 */
	private static void searchRequestWithQueryParameters() throws IOException {
		//?spaceKey=TES&title=Testseite&expand=space"
		GenericUrl url = new GenericUrl(TEST_URL);
		url.put("cql", "space=TES and type=PAGE and lastmodified<=2020-03-29");
//		url.put("cql", "space=TES and type=PAGE and lastmodified=2019-08-03 and text~Test and metadataset = global.metadataset.meta01");
//		url.put("title", "Testseite");
		url.put("expand", "space,body.view,version,container");
		HttpRequest req = reqFactory().buildGetRequest(url);
		System.out.println("Request: "  + req.getUrl());
		req.setParser(new JsonObjectParser(JSON_FACTORY));
		String json = (String)req.execute().parseAsString();
		SearchResults results  = new Gson().fromJson(json, SearchResults.class);
		System.out.println("Json: " + json);
		for (Result content : results.getResults()) {
			System.out.println("Content: Id: " + content.getId());
			System.out.println("Content: Title: " + content.getTitle());
			System.out.println("Content: Type: " + content.getType());
			System.out.println("Content: Status: " + content.getStatus());
		}

	}


}
