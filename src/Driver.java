import java.util.Optional;
import java.util.Scanner;

import booking.EventBookingSystem;
import event.Event;
import exception.InvalidBookingException;
import user.Attendee;
import user.User;

public class Driver {

	public static void main(String[] args) throws InvalidBookingException {
		// TODO Auto-generated method stub
		System.out.println("Welcome to Event Booking System");
		EventBookingSystem ob =new EventBookingSystem();
		ob.loadEvents();
		while(true) {
			Scanner sc = new Scanner(System.in);
			 System.out.println("\n === Event Booking System Menu ===");
	            System.out.println("||1. Register a Attendee       ||");
	            System.out.println("||2. Add Event                 ||");
	            System.out.println("||3. Book Ticket               ||");
	            System.out.println("||4. Show All Events           || ");
	            System.out.println("||5. Save Data and Exit        ||");
	            System.out.println("=================================");
	            System.out.print("Enter your choice: ");
			switch(sc.nextInt()) {
				case 1 : {
					System.out.println("Enter Attendee ID: ");
                    String atnId = sc.next();
                    System.out.println("Enter Attendee Name: ");
                    String atnName = sc.next();
                    Attendee a = new Attendee(atnId, atnName);
                    ob.registerUser(a);
                    System.out.println("Attendee registered successfully!");
                    break;
				}
				case 2 : {
					System.out.println("Enter Event Tile: ");
                    String evId = sc.next();
                    System.out.println("Enter Event Capacity: ");
                    int evCap = sc.nextInt();
                    ob.addEvent(new Event(evId, evCap));
                    System.out.println("event added successfully!");
                    break;
				}
				case 3 : {
					String id = sc.next();
					String title = sc.next();
					
					ob.bookTicket(id, title);
				}
				case 4 : {
					ob.showEvents();
					break;
				}
				case 5 : {
					System.out.println("Closing the system......");
					System.exit(0);
				}
			}
		}
	}

}
