package exception;

public class CoursException extends RuntimeException {

	public CoursException() {
		
	}
	
	// exception avec un msg si on a envie

	public CoursException(String message) {
		super(message);
	}
}
	
	


