package jiratest;

import java.util.List;

import com.atlassian.jira.rest.client.api.domain.Issue;

public class RestClientTest {
	public static void main(String[] args) {
			
		MyJiraClient rcl = new MyJiraClient("rroger_de", "roger03", "http://localhost:8080");
		if(args.length > 0) {
			String issue = rcl.createIssue("SCRUM", 10005L, args[0]);
			System.out.println("==========> Neuer Issue Nr ====> " + issue);
			
		}
		
		rcl.updateIssueDescription("SCRUM-11", "Die Beschreibung für SCRUM-11 nochmal geändert");
		String issueInfo = rcl.getIssueInfo("SCRUM-11");
		System.out.println("==========> Info: " + issueInfo);
		List<Issue> issues = rcl.getListeIssues("project=SCRUM_Projekt");
		// System.out.println("==========> List: " + issues);
		for (Issue issue : issues) {
			System.out.println("----------------------------------------------------------------------");
			System.out.println("===> Name: " + issue.getKey() + " / " + issue.getSummary());
		}
		System.out.println("--------------------- ENDE ---------------------");
	}
}
