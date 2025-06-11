package Activites;

public class StringEmptyException extends Exception {
	private String message;
	public StringEmptyException(String message) {
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		return "The error happens because:" + this.message;
	}

}
