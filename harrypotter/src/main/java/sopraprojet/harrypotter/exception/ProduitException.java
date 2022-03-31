package exception;

public class ProduitException extends RuntimeException {

	public ProduitException() {
		
	}
	
	// exception avec un msg si on a envie

	public ProduitException(String message) {
		super(message);
	}
	
	
}
