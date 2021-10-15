package ConfRestClient;

import com.atlassian.confluence.rest.client.RestClientFactory;
import com.sun.jersey.api.client.Client;


public class StartClient {

	public static void main(String[] args) {
		Client client = RestClientFactory.newClient();

	}
	
}
