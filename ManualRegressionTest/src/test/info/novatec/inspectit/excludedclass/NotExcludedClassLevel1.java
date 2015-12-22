package test.info.novatec.inspectit.excludedclass;

import org.testng.annotations.Test;

/**
 * Test of exclude in config-file
 * 
 * @author Alfred Kraus
 */
public class NotExcludedClassLevel1 {

	@Test
	public void callExcludedClass() {
		ExcludedClassLevel2 excludedclasslevel2 = new ExcludedClassLevel2();
		excludedclasslevel2.callNotExcludedClassLevel3();
	}

}
