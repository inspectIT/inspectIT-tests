import org.testng.annotations.Test;

/**
 * Test if methods in default package are instrumented
 * 
 * @author Alfred Kraus
 */
public class DefaultPackageTestFile {

	/**
	 * Simple method which can be seen the instrumentation browser of inspectIT
	 */
	@Test
	public void simpleOutput() {
		System.out.println("Starting test of DefaultPackage...");
		System.out.println("Test of DefaultPackage - Finished");
	}
}
