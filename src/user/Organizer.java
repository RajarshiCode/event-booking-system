package user;

public class Organizer extends User{
	
	protected boolean active;
	public Organizer(String id, String name) {
		super(id, name);
		this.active = true;
	}

	@Override
	public void showProfile() {		
		System.out.println("Organizer Info: ID->"+id+", Name->"+name);
	}
	
	public boolean isActive() {
		return active;
	}
	
	public void setActive(boolean val) {
		active = val;
	}
	
}
