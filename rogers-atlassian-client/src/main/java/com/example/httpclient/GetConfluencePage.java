package com.example.httpclient;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.example.httpclient.objects.atlassian.Content2;
import com.example.httpclient.objects.atlassian.Results;
import com.example.httpclient.objects.users.GitHubUser;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpContent;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.UrlEncodedContent;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.http.json.JsonHttpContent;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.Key;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class GetConfluencePage {

	private static final JsonFactory JSON_FACTORY = new JacksonFactory();

	private static final String TEST_URL = "http://localhost:8090/rest/api/content";

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
		getRequestWithQueryParameters();

		//postRequestFormUrlencoded();

		//postSimpleJsonData();

		//postComplexJsonData();

		//parsePublicApiJsonResponse();
		System.out.println("ENDE");
	}

	/**
	 * Submit a GET request with query parameters
	 *
	 * @throws IOException
	 */
	private static void getRequestWithQueryParameters() throws IOException {
		//?spaceKey=TES&title=Testseite&expand=space"
		GenericUrl url = new GenericUrl(TEST_URL);
		url.put("spaceKey", "TES");
		url.put("title", "Testseite");
		url.put("expand", "space,body.view,version,container");
		HttpRequest req = reqFactory().buildGetRequest(url);
		req.setParser(new JsonObjectParser(JSON_FACTORY));
		String json = (String)req.execute().parseAsString();
		Results results  = new Gson().fromJson(json, Results.class);
		System.out.println("Json: " + json);
		for (Content2 content : results.getResults()) {
			System.out.println("Content: Id: " + content.getId());
			System.out.println("Content: Title: " + content.getTitle());
			System.out.println("Content: Type: " + content.getType());
			System.out.println("Content: Space: " + content.getSpace().getName());
		}

	}

	/**
	 * Parse the JSON response of the public Github API.
	 *
	 * @throws IOException
	 */
	@SuppressWarnings("unused")
	private static void parsePublicApiJsonResponse() throws IOException {
		GenericUrl url = new GenericUrl("https://api.github.com/users");
		url.put("per_page", 5);
		HttpRequest req = reqFactory().buildGetRequest(url);
		// Set the parser to use for parsing the returned JSON data
		req.setParser(new JsonObjectParser(JSON_FACTORY));

		// Use GSON's TypeToken to let the parser know to expect a List<GithubUser>
		Type type = new TypeToken<List<GitHubUser>>() {}.getType();

		@SuppressWarnings("unchecked")
		List<GitHubUser> users = (List<GitHubUser>) req.execute().parseAs(type);
		if (null != users && !users.isEmpty()) {
			System.out.println("GithubUser 0: " +users.size() + " ---- " + users.get(0));
		}
		int i = 0;
		for (GitHubUser gitHubUser : users) {
			System.out.println("Github users " + ++i + " - " + gitHubUser);
			gitHubUser.getId(); 
		}
	}

	/**
	 * Submit a POST request with JSON data in the payload where the value of one of
	 * the properties is an object (not just a primitive type).
	 *
	 * @throws IOException
	 */
	@SuppressWarnings("unused")
	private static void postComplexJsonData() throws IOException {
		GenericUrl url = new GenericUrl(TEST_URL);
		Map<String, Object> data = new LinkedHashMap<>();
		data.put("arg1", true);
		data.put("arg2", 45);
		CustomObj customDto = new CustomObj();
		customDto.id = 5001;
		customDto.name = "Harshdeep S Jawanda";
		data.put("arg3", customDto);
		HttpContent content = new JsonHttpContent(JSON_FACTORY, data);
		reqFactory().buildPostRequest(url, content).execute();
	}

	/**
	 * Submit an x-www-form-urlencoded POST request (like submitting an ordinary
	 * HTML form)
	 *
	 * @throws IOException
	 */
	@SuppressWarnings("unused")
	private static void postRequestFormUrlencoded() throws IOException {
		GenericUrl url = new GenericUrl(TEST_URL);
		Map<String, Object> data = new LinkedHashMap<>();
		data.put("arg1", true);
		data.put("arg2", 45);
		HttpContent content = new UrlEncodedContent(data);
		reqFactory().buildPostRequest(url, content).execute();
	}

	/**
	 * Submit a POST request with simple JSON data in the payload (i.e., where the
	 * values of all properties are primitives).
	 *
	 * @throws IOException
	 */
	@SuppressWarnings("unused")
	private static void postSimpleJsonData() throws IOException {
		GenericUrl url = new GenericUrl(TEST_URL);
		Map<String, Object> data = new LinkedHashMap<>();
		data.put("arg1", true);
		data.put("arg2", 45);
		HttpContent content = new JsonHttpContent(JSON_FACTORY, data);
		reqFactory().buildPostRequest(url, content).execute();
	}

	/**
	 * A custom DTO created as an example. In a real DTO class you would typically
	 * have getters & setters.
	 */
	private static class CustomObj {

		@Key
		private int id;

		@Key
		private String name;

	}

}
