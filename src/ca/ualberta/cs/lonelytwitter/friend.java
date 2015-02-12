package ca.ualberta.cs.lonelytwitter;

public class friend {
	private String friendname;
	private String relations;
	public String getFriendname() {
		return friendname;
	}
	public void setFriendname(String friendname) {
		this.friendname = friendname;
	}
	public String getRelations() {
		return relations;
	}
	public void setRelations(String relations) {
		this.relations = relations;
	}
	public friend(String friendname, String relations) {
		super();
		this.friendname = friendname;
		this.relations = relations;
	}
	
}
