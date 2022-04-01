package sopraprojet.harrypotter.exception;

public class LivraisonException extends RuntimeException {

	public LivraisonException() {
		
	}
	
	// exception avec un msg si on a envie

	public LivraisonException(String message) {
		super(message);
	}
}
