package test.info.novatec.inspectit.exceptions;

import java.io.IOException;

import org.testng.annotations.Test;

/**
 * Throwing and catching exceptions with and without cause. Thrown exceptions
 * can be seen in inspectIT
 * 
 * @author Alfred Kraus
 * 
 */
public class ThrowExceptions {

	@Test(expectedExceptions = MainException.class)
	public void throwMainException() throws MainException {
		throw new MainException("MainException tested");
	}

	@Test(expectedExceptions = Level1SubException.class)
	public void throwLevel1SubException() throws Level1SubException {
		throw new Level1SubException("Level1SubException tested");
	}

	@Test(expectedExceptions = Level2SubException.class)
	public void throwLevel2SubException() throws Level2SubException {
		throw new Level2SubException("Level2SubException tested");
	}

	@Test(expectedExceptions = CauseException.class)
	public void throwCauseException() throws CauseException {
		try {
			throw new IOException();
		} catch (IOException e) {
			throw new CauseException("Faked IOException caught", e);
		}
	}

	@Test
	public void passingExceptions() throws MainException {
		try {
			System.out.println("Throwing MainException...");
			throw new MainException("MainException thrown");
		} catch (MainException mainException) {
			System.out
					.println("Catched MainException. Throw Level1SubExcetpion...");
			try {
				throw new Level1SubException("Level1SubException thrown");
			} catch (Level1SubException level1SubException) {
				System.out
						.println("Catched Level1SubException. Throw Level2SubException...");
				try {
					throw new Level2SubException("Level2SubException thrown");
				} catch (Level2SubException level2SubException) {
					System.out
							.println("Catched Level2SubException. Calling \"Catchmethod\" of Level2Subexception...");
					level2SubException.catchAll();
				}
			}
		}
	}

}
