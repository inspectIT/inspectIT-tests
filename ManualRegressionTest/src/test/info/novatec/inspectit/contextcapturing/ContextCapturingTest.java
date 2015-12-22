package test.info.novatec.inspectit.contextcapturing;

import org.testng.annotations.Test;

/**
 * Test if context capturing works
 * 
 * Simple methods are called with various parameters which can be seen in
 * inspectIT. Inspected parameters are defined in ContextCapturing.config
 * 
 * @author Alfred Kraus
 */
public class ContextCapturingTest {

	int value = 0;

	Sub1 sub = new Sub1();

	class Sub1 {
		String sub1 = "Sub1";
	}

	public ContextCapturingTest() {
		@SuppressWarnings("unused")
		Sub1 sub1 = new Sub1();
	}

	@Test
	public void contextCapturingTest() {
		value += contextCapturing1();
		value++;
	}

	// @Test
	public int contextCapturing1() {
		value = contextCapturing2(4, 5);
		// Test
		return value;
	}

	// @Test
	public int contextCapturing2(int param1, int param2) {
		value += param1 + param2;
		String s = "some\nstring\nin\nfew\nlines";
		contextCapturingString(s);
		return value;
	}

	// @Test
	public void contextCapturingString(String param) {
	}
}
