package com.example.httpclient;
import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public class GitHubUser extends GenericJson{
  
    @Key
    private String login;
    @Key
    private long id;
    @Key("email")
    private String email;
 
 // standard getters and setters
    
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
 
    
    
}