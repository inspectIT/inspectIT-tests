package test.info.novatec.inspectit.invocationsequence;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;

/**
 * Subclass of InvocationSequence calling another Subclass
 * 
 * @author Alfred Kraus
 */
public class InvocationSequenceLevel2{
	private boolean testvalue = false;
	
	public boolean getLevel3TestValue(){
		InvocationSequenceLevel3 level3 = new InvocationSequenceLevel3();
		testvalue = level3.returnTestValue();
		return testvalue;
	}
	
	public boolean getLevel3MinDurationTestValue(){
		InvocationSequenceLevel3 level3 = new InvocationSequenceLevel3();
		testvalue = level3.returnTestValueAfterMinDUration();
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			System.err.println("Error while waiting 2s");
		}
		return testvalue;
	}
	
	public void invocationSequenceSensortestsLevel2() throws SQLException, ServletException, IOException{
		InvocationSequenceLevel3 level3 = new InvocationSequenceLevel3();
		level3.invocationSequenceSensortestsLevel3();
	}

	public void testSteppingFeature() {
		InvocationSequenceLevel3 level3 = new InvocationSequenceLevel3();
		level3.testSteppingFeature();
		level3.testSteppingFeature();
		level3.testSteppingFeature();
	}

	public void testSteppingFeatureSQL() throws SQLException {
		InvocationSequenceLevel3 level3 = new InvocationSequenceLevel3();
		level3.testSteppingFeatureSQL();
		level3.testSteppingFeatureSQL();
		level3.testSteppingFeatureSQL();
	}
	
}
