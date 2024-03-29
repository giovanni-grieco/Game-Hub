package it.uniroma3.siw.GameHub.controller.form;

import it.uniroma3.siw.GameHub.model.Credentials;
import it.uniroma3.siw.GameHub.model.User;

public class UserForm {
	private Credentials credentials;
	private User user;
	
	public UserForm(Credentials credentials, User user) {
		this.credentials = credentials;
		this.user=user;
	}
	public Credentials getCredentials() {
		return credentials;
	}
	public void setCredentials(Credentials credentials) {
		this.credentials = credentials;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
