package exceptions;


public class RecordNotFoundException extends RuntimeException {

	
	private static final long serialVersionUID = -7046039672890258427L;

	public RecordNotFoundException(String message) {
		super( message);
	}
	
}