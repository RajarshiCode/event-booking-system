package event;

import user.Attendee;

public class Ticket {
	 protected Attendee attendee;
	 protected Event event;
	 protected String status;
	 
	 
	 public Ticket(Attendee attendee, Event event) {
		 this.attendee = attendee;
		 this.event = event;
		status = "Booked";
	}
	 
	 void cancel() {
		 event.availableTickets = event.availableTickets+1;
		 status = "canceled";
	 }
	 
	 String getStatus() {
		 return status;
	 }
	 String ticketDetails() {
		 return "Event Title: "+event.title+", status: "+status;
	 }
	 
}
