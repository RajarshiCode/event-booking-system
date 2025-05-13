package user;

public class Attendee extends User{

	Attendee(String id, String name) {
		super(id, name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void showProfile() {
		// TODO Auto-generated method stub
		System.out.println("Attendee Info: ID->"+id+", Name->"+name);
	}
	

}
