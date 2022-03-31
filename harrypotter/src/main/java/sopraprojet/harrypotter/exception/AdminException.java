package exception;

public class AdminException extends RuntimeException {

	public AdminException() {
		
	}
	
	// exception avec un msg si on a envie

	public AdminException(String message) {
		super(message);
	}

}
