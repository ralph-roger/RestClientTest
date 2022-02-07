package com.example.httpclient;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.IOUtils;

import com.example.httpclient.objects.users.GitHubUser;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpContent;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.UrlEncodedContent;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.http.json.JsonHttpContent;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.Key;
import com.google.gson.reflect.TypeToken;

public class StartClass {

	private static final JsonFactory JSON_FACTORY = new JacksonFactory();

	private static final String TEST_URL = "http://httpclient.requestcatcher.com/test";

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
		System.out.println("Start");
		// Request und Ausgabe der Response
		getRequestWithQueryParameters();
		// Simpler Post
		postSimpleJsonData();
		// Post mit einem Objekt als Variable
		postComplexJsonData();
		// Aufruf Github API Liste der User 
		parsePublicApiJsonResponse();
		
		System.out.println("ENDE");
	}

	/**
	 * Submit a GET request with query parameters
	 *
	 * @throws IOException
	 */
	private static void getRequestWithQueryParameters() throws IOException {
		GenericUrl url = new GenericUrl(TEST_URL);
		url.put("arg1", true);
		url.put("arg2", 45);
		HttpResponse resp = reqFactory().buildGetRequest(url).execute();
		System.out.println("=================> getReqWithParameters " + resp.getStatusMessage() + " > " + resp.getStatusCode());
		System.out.println(doGetContentFromStream(resp)); 
	}


	/**
	 * Submit an x-www-form-urlencoded POST request (like submitting an ordinary
	 * HTML form)
	 *
	 * @throws IOException
	 */
	private static void postSimpleJsonData() throws IOException {
		GenericUrl url = new GenericUrl(TEST_URL);
		Map<String, Object> data = new LinkedHashMap<>();
		data.put("arg1", true);
		data.put("arg2", 45);
		HttpContent content = new UrlEncodedContent(data);
		HttpResponse resp = reqFactory().buildPostRequest(url, content).execute();
		System.out.println(doGetContentFromStream(resp)); 
		
	}

	
	/**
	 * Submit a POST request with JSON data in the payload where the value of one of
	 * the properties is an object (not just a primitive type).
	 *
	 * @throws IOException
	 */
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
		HttpResponse resp = reqFactory().buildPostRequest(url, content).execute();
		System.out.println(doGetContentFromStream(resp)); 
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
	
	/**
	 * Parse the JSON response of the public Github API.
	 *
	 * @throws IOException
	 */
	private static void parsePublicApiJsonResponse() throws IOException {
		GenericUrl url = new GenericUrl("https://api.github.com/users");
		url.put("per_page", 10);
		HttpRequest req = reqFactory().buildGetRequest(url);
		// Set the parser to use for parsing the returned JSON data
		req.setParser(new JsonObjectParser(JSON_FACTORY));

		// Use GSON's TypeToken to let the parser know to expect a List<GithubUser>
		Type type = new TypeToken<List<GitHubUser>>() {}.getType();

		@SuppressWarnings("unchecked")
		List<GitHubUser> users = (List<GitHubUser>) req.execute().parseAs(type);
		if (null != users && !users.isEmpty()) {
			System.out.println("GithubUser 0: " + users.size() + " ---- " + users.get(0));
		}
		int i = 0;
		for (GitHubUser gitHubUser : users) {
			System.out.println(gitHubUser.getLogin() + " " + ++i + " - " + gitHubUser);
			gitHubUser.getId(); 
		}
	}
	
	/**
	 * Hole den Content from response
	 * @param response the response of the Server 
	 * @return Content as String
	 * @throws IOException
	 */
	private static String doGetContentFromStream(HttpResponse resp) {
		
		String out = "";
		// Ab der Java-Version 7 ist es möglich, durch ein try-with-resources Statement dies erheblich 
		// zu vereinfachen und das Schließen des Stroms automatisch auszuführen.
		try (InputStream in = resp.getContent();) {		
			out = IOUtils.toString(in,StandardCharsets.UTF_8);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return out;
	}
}