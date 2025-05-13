package user;

public class Attendee extends User{

	public Attendee(String id, String name) {
		super(id, name);		
	}

	@Override
	public void showProfile() {
		// TODO Auto-generated method stub
		System.out.println("Attendee Info: ID->"+id+", Name->"+name);
	}
	

}
