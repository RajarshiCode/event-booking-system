package exception;

@SuppressWarnings("serial")
public class InvalidBookingException extends Exception{

	public InvalidBookingException(String msg) {
		super(msg);		
	}
	
}
