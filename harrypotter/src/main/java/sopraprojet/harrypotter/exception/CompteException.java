package sopraprojet.harrypotter.exception;

public class CompteException extends RuntimeException {

	public CompteException() {
		
	}
	
	// exception avec un msg si on a envie

	public CompteException(String message) {
		super(message);
	}

}

