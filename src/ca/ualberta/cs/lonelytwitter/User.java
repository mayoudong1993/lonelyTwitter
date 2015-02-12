package ca.ualberta.cs.lonelytwitter;

import java.io.IOException;
import java.util.List;

public abstract class User extends Object implements UserLike {
	protected String username;
	protected List<friend> friends;
	public String getUsername() {
		return username;
	}

	public abstract void setUsername(String x) throws IOException;
	
	public User(String username) {
		super();
		this.username = username;
	}
	
	public User() {
		super();
		this.username = "anonymous";
	}

	public List<friend> getFriends() {
		return friends;
	}

	public void setFriends(List<friend> friends) {
		this.friends = friends;
	}
	
	
	
}
