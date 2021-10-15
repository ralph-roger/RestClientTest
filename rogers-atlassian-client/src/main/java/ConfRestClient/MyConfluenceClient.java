package ConfRestClient;

import java.net.URI;

import com.atlassian.confluence.rest.client.RestClientFactory;
import com.sun.jersey.api.client.Client;

public class MyConfluenceClient {

	
	/***
	 * 
	 * @author ralph Reifegerste
	 * @version 0.0.1
	 * 
	 * Klasse stellt einen eigenen ConfluenceClient mit Funktionalitäten zur Verfügung.
	 * 
	 */

		/** username ein Jira User */
		String username;
		/** das Passwort */
		String password;
		/** URL des Confluence */
		String ConfluenceUrl;
		/** ein RestClient */
		Client crc;

		/**
		 * Der Konstruktor baut den Client.
		 * @param username s.o.
		 * @param password s.o.
		 * @param jiraurl s.o.
		 */
		public MyConfluenceClient(String username, String password, String url) {
			this.username = username;
			this.password = password;
			this.ConfluenceUrl = url;
			this.crc = getConfluenceRestClient();
		}
		
		/**
		 * getJiraRestClient über Factory erzeugen 
		 * @return JiraRestClient den Client
		 */

		private Client getConfluenceRestClient() {
			new RestClientFactory();
			return RestClientFactory.newClient();
		}
		

		private URI getConfluenceUri() {
			return URI.create(this.ConfluenceUrl);
		}
		
}
