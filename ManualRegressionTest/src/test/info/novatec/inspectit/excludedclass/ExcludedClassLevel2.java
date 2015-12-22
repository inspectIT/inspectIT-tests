package test.info.novatec.inspectit.excludedclass;

/**
 * Test of exclude in config-file
 * 
 * @author Alfred Kraus
 */
public class ExcludedClassLevel2 {

	public void callNotExcludedClassLevel3() {
		NotExcludedClassLevel3 notexcludedclasslevel3 = new NotExcludedClassLevel3();
		notexcludedclasslevel3.simpleOutput();
	}

}
