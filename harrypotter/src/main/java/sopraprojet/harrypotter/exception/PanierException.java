package sopraprojet.harrypotter.exception;

public class PanierException extends RuntimeException{


	public PanierException() {
		
	}
	
	// exception avec un msg si on a envie

	public PanierException(String message) {
		super(message);
	}
	
}
