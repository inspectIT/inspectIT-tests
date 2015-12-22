package test.info.novatec.inspectit.exceptions;

/**
 * Empty exception with a cause
 * 
 * @author Alfred Kraus
 */
public class CauseException extends Exception {

	private static final long serialVersionUID = 1L;

	public CauseException(String message, Throwable cause) {
		super(message, cause);
	}

}
