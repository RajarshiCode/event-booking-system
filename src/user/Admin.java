package user;

import role.RoleRequired;

@RoleRequired(role="Admin")
public class Admin extends User{

	Admin(String id, String name) {
		super(id, name);
	}

	@Override
	public void showProfile() {
		System.out.println("Admin Info: ID->"+id+", Name->"+name);
	}
	
}
