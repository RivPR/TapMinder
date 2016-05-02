package data;

import entities.User;

public class LoginResult {

	User user;
	String message;
	
	public LoginResult(){
		
	}

	public LoginResult(User user, String message) {
		super();
		this.user = user;
		this.message = message;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
	
}
