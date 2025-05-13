package user;

import java.util.Iterator;
import java.util.List;

import event.Event;
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
	
	public void removeEvent(List<Event> events, String title) {
        try {
            Class<?> cls = this.getClass();
            if (cls.isAnnotationPresent(RoleRequired.class)) {
            	RoleRequired role = cls.getAnnotation(RoleRequired.class);
                if ("Admin".equals(role.role())) {
                    Iterator<Event> iterator = events.iterator();
                    while (iterator.hasNext()) {
                        Event event = iterator.next();
                        if (event.title.equals(title)) {
                            iterator.remove();
                            System.out.println("Event Tile " + title + " removed.");
                            return;
                        }
                    }
                    System.out.println("Event Tile " + title + " not found.");
                } else {
                    System.out.println("Unauthorized Access!");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
