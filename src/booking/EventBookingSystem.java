package booking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import event.Event;
import event.Ticket;
import exception.InvalidBookingException;
import user.*;

public class EventBookingSystem {
	List<Attendee> atn;
	List<Organizer> org;
	List<Event> ev;
	List<Ticket> ti;
	
	
	public EventBookingSystem() {
		atn = new ArrayList<Attendee>();
		org = new ArrayList<Organizer>();
		ev = new ArrayList<Event>();
		ti = new ArrayList<Ticket>();
	}

	

	public void loadEvents() {
		try (BufferedReader reader = new BufferedReader(new FileReader("D:\\filesCreating\\events.txt"))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] parts = line.split(",");
				if (parts.length >= 2) {
					String title = parts[0];
					String no = parts[1];
					Event e = new Event(title, Integer.parseInt(no));
					ev.add(e);
				}
			}
		} catch (IOException e) {
			System.out.println("Events file not found. Starting fresh.");
		}
	}

	public void saveEvents() {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\filesCreating\\events.txt"))) {
			for (Event x : ev) {
				writer.write(x.title + ", " + x.availableTickets);
				writer.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void showEvents() {
		for (Event x : ev) 
			x.display();		
	}
	
	public void addEvent(Event e) {
		ev.add(e);
	}
	
	public void registerUser(User user) {
		if (user instanceof Attendee) 
			atn.add((Attendee) user);
        else if (user instanceof Organizer)
        	org.add((Organizer) user);
	}
	
	public void bookTicket(String attendeeId, String eventTitle) throws InvalidBookingException {
		Attendee attendee = atn.stream().filter(a -> a.id.equals(attendeeId)).findFirst().orElse(null);
		if (attendee == null ) {
            throw new InvalidBookingException("Attendee ID not Found. Register First");
        }
        Event event = ev.stream().filter(e -> e.getTitel().equalsIgnoreCase(eventTitle)).findFirst().orElse(null);
        if (event == null) {
            throw new InvalidBookingException("Invalid booking request. No Such Event");
        }
        if (!event.isAvailable()) {
            throw new InvalidBookingException("Invalid booking request. No Tickets Available");
        }

        event.setAvailableTickets(event.getAvailableTickets() - 1);
        Ticket ticket = new Ticket(attendee, event);
        ti.add(ticket);
        System.out.println("Ticket booked successfully!");
	}
	
	

}
