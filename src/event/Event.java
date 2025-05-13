package event;

public class Event {
	public String title;
	public int availableTickets;
	public Event(String title, int availableTickets) {		
		this.title = title;
		this.availableTickets = availableTickets;
	}
	
	public boolean isAvailable() {
		return (availableTickets>0)? true : false;
	}
	public void setAvailableTickets(int n) {
		availableTickets = n;
	}
}
