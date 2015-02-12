package ca.ualberta.cs.lonelytwitter;

public class Readers extends User {
	@Override
	public void setUsername(String x) {
		if (x.length() <= 8 ){
			throw new RuntimeException("Name too short!"); 
		}
		this.username = x;
	}
	
}
