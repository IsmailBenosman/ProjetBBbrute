package exception;

public class EleveException extends RuntimeException {

	public EleveException() {
		
	}
	
	// exception avec un msg si on a envie

	public EleveException(String message) {
		super(message);
	}
	
	
}
