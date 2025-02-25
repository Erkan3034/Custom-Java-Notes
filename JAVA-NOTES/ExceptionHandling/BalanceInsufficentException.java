package ExceptionHandling;

public class BalanceInsufficentException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String _message;

	public BalanceInsufficentException(String message) {
		_message = message;
	}
	@Override
	public String getMessage() {
		return _message;
		
	}  

}
