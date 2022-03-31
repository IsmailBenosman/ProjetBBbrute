package sopraprojet.harrypotter.exception;

public class MaisonException extends RuntimeException {

	public MaisonException() {
		
	}
	
	// exception avec un msg si on a envie

	public MaisonException(String message) {
		super(message);
	}
	
	
}