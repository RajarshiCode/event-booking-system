package user;

public abstract class User {
	public String id;
	public String name;
	
	public User(String id, String name){
		this.id = id;
		this.name = name;
	}
	
	
	public abstract void showProfile();
}
