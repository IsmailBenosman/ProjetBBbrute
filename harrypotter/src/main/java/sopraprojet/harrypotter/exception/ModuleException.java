package exception;

public class ModuleException extends RuntimeException {

	public ModuleException() {
		
	}
	
	// exception avec un msg si on a envie

	public ModuleException(String message) {
		super(message);
	}
	
	
}

	
	


