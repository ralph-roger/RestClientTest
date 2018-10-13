package jiratest;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;

import com.atlassian.jira.rest.client.api.IssueRestClient;
import com.atlassian.jira.rest.client.api.JiraRestClient;
import com.atlassian.jira.rest.client.api.SearchRestClient;
import com.atlassian.jira.rest.client.api.domain.BasicVotes;
import com.atlassian.jira.rest.client.api.domain.Filter;
import com.atlassian.jira.rest.client.api.domain.Issue;
import com.atlassian.jira.rest.client.api.domain.SearchResult;
import com.atlassian.jira.rest.client.api.domain.input.IssueInput;
import com.atlassian.jira.rest.client.api.domain.input.IssueInputBuilder;
import com.atlassian.jira.rest.client.internal.async.AsynchronousJiraRestClientFactory;
import com.atlassian.util.concurrent.Promise;

/***
 * 
 * @author ralph Reifegerste
 * @version 0.0.1
 * 
 * Klasse stellt einen eigenen JiraClient mit Funktionalitäten zur Verfügung.
 * 
 */

public class MyJiraClient {
	/** username ein Jira User */
	String username;
	/** das Passwort */
	String password;
	/** URL des Jira */
	String jiraurl;
	/** ein JiraRestClient */
	JiraRestClient jrc;

	/**
	 * Der Konstruktor baut den Client.
	 * @param username s.o.
	 * @param password s.o.
	 * @param jiraurl s.o.
	 */
	public MyJiraClient(String username, String password, String jiraurl) {
		this.username = username;
		this.password = password;
		this.jiraurl = jiraurl;
		this.jrc = getJiraRestClient();
	}
	
	/**
	 * getJiraRestClient über Factory erzeugen 
	 * @return JiraRestClient den Client
	 */

	private JiraRestClient getJiraRestClient() {
		return new AsynchronousJiraRestClientFactory().createWithBasicHttpAuthentication(getJiraUri(), this.username,
				this.password);
	}
	

	private URI getJiraUri() {
		return URI.create(this.jiraurl);
	}
	
	public String createIssue(String projectKey, Long issueType, String issueSummary) {
	    IssueRestClient issueClient = jrc.getIssueClient(); 
	    IssueInput newIssue = new IssueInputBuilder(
	      projectKey, issueType, issueSummary).build();
	    return issueClient.createIssue(newIssue).claim().getKey();
	}
	
	public void updateIssueDescription (String issueKey, String description) {
		IssueInput issueInput = new IssueInputBuilder()
				.setDescription(description)
				.build();
		jrc.getIssueClient().updateIssue(issueKey, issueInput);
	}
	
	public String getIssueInfo(String issueKey) {
		
		Issue issue = jrc.getIssueClient().getIssue(issueKey).claim();
		System.out.println("---> " + issue);
		String issueInfo =  issue.getKey() + "#" + issue.getAssignee().getDisplayName() + "#" + issue.getCreationDate() + "#" +  issue.getSummary();
		return issueInfo;
	}
	
	public Issue getIssue(String issueKey) {
		
		Issue issue = jrc.getIssueClient().getIssue(issueKey).claim();
		System.out.println("---> " + issue);
		
		return issue;
	}
	
	public void voteForIssue(Issue issue) {
		jrc.getIssueClient().vote(issue.getVotesUri()).claim();
	}
	
	public int getTotalVotes(String issueKey) {
		BasicVotes votes = getIssue(issueKey).getVotes();
		
		return votes == null ? 0 : votes.getVotes();
		
	}
	
	public List<Issue> getListeIssues(String issueKey) {
		List<Issue> iList = new ArrayList<Issue>();
		SearchRestClient jsrc = jrc.getSearchClient();
		Promise<SearchResult> searchResult = jsrc.searchJql(issueKey);
		try {
			searchResult.get().getIssues();
			for (Issue issue : searchResult.get().getIssues()) {
				iList.add(issue);
			}		
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return iList;
	}

}
