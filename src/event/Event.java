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
	
	
	public void display() {
		System.out.println("Event title : "+title+", no of tickets: "+availableTickets);
	}

	public String getTitel() {		
		return title;
	}

	public int getAvailableTickets() {
		// TODO Auto-generated method stub
		return availableTickets;
	}
}
