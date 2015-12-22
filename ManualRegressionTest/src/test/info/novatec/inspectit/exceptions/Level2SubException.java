package test.info.novatec.inspectit.exceptions;

/**
 * Last instance of Exceptions. Providing a String.
 * 
 * @author Alfred Kraus
 */
public class Level2SubException extends Level1SubException {

	private static final long serialVersionUID = 1L;

	public Level2SubException(String message) {
		super(message);
	}

	public void catchAll() {
		System.out.println("Catched Exception on Level 2");
	}
}
