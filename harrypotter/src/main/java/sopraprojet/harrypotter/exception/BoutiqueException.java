package exception;

public class BoutiqueException extends RuntimeException {

	public BoutiqueException() {
		
	}
	
	// exception avec un msg si on a envie

	public BoutiqueException(String message) {
		super(message);
	}
}
	