package test.info.novatec.inspectit.exceptions;

/**
 * Empty exception. Serves as main for subexceptions
 * 
 * @author Alfred Kraus
 */
public class MainException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public MainException(String message) {
		super(message);
	}
}
