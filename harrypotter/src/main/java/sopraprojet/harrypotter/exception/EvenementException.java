package exception;

public class EvenementException extends RuntimeException {

	public EvenementException() {
		
	}
	
	// exception avec un msg si on a envie

	public EvenementException(String message) {
		super(message);
	}
	
	
}
