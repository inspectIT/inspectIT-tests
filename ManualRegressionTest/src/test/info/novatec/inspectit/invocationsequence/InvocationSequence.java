package test.info.novatec.inspectit.invocationsequence;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;

import org.testng.annotations.Test;

import test.info.novatec.inspectit.http.HttpFeatures;
import test.info.novatec.inspectit.sql.SQLFeatures;
import test.info.novatec.inspectit.sql.tools.ConnectionFactory;

/**
 * First instance of invocation sequence. Mainclass for calling other,
 * instrumented classes
 * 
 * @author Alfred Kraus
 * 
 */
public class InvocationSequence {

	/**
	 * simple invocationsequence
	 */
	@Test
	public void testSimpleInvocationSequence() {
		System.out.println("Starting simple invocationsequence - Test...");

		InvocationSequenceLevel2 level2 = new InvocationSequenceLevel2();
		level2.getLevel3TestValue();

		System.out.println("Finished simple invocationsequence - Test");
	}

	/**
	 * calling the same method multiple times in different stages of the
	 * invocation sequence
	 */
	@Test
	public void testSteppingFeature() {
		InvocationSequenceLevel3 level3 = new InvocationSequenceLevel3();
		level3.testSteppingFeature();
		level3.testSteppingFeature();
		level3.testSteppingFeature();
		InvocationSequenceLevel2 level2 = new InvocationSequenceLevel2();
		level2.testSteppingFeature();
		level2.testSteppingFeature();
		level2.testSteppingFeature();
	}

	/**
	 * calling the same sql multiple times in different stages of the invocation
	 * sequence
	 * 
	 * @throws SQLException
	 */
	@Test
	public void testSteppingFeatureSQL() throws SQLException {
		InvocationSequenceLevel3 level3 = new InvocationSequenceLevel3();
		level3.testSteppingFeatureSQL();
		level3.testSteppingFeatureSQL();
		level3.testSteppingFeatureSQL();
		InvocationSequenceLevel2 level2 = new InvocationSequenceLevel2();
		level2.testSteppingFeatureSQL();
		level2.testSteppingFeatureSQL();
		level2.testSteppingFeatureSQL();
	}

	/**
	 * Pool with tests for sensors without an invocation sequence
	 * 
	 * @throws SQLException
	 * @throws ServletException
	 * @throws IOException
	 */
	@Test
	public void noInvocationSequenceSensortests() throws SQLException,
			ServletException, IOException {
		System.out.println("Starting tests WITHOUT invocation sequence");
		System.out.println();

		timerSensortest();
		databaseSensortest();
		exceptionSensortest();
		plattformSensortest();
		httpSensortest();

		System.out.println();
		System.out.println("Finished tests WITHOUT invocationsequence");
	}

	/**
	 * Calls a pool with tests for sensors within an invocation sequence
	 * 
	 * @throws SQLException
	 * @throws ServletException
	 * @throws IOException
	 */
	@Test
	public void invocationSequenceSensortests() throws SQLException,
			ServletException, IOException {
		InvocationSequenceLevel2 level2 = new InvocationSequenceLevel2();
		level2.invocationSequenceSensortestsLevel2();
	}

	/**
	 * Test of the MinDuration-Feature
	 */
	@Test
	public void testMinDurationInvocationSequence() {
		System.out.println("Starting MinDuration - Timertest...");

		try {
			Thread.sleep(3000);
			InvocationSequenceLevel2 level2 = new InvocationSequenceLevel2();
			level2.getLevel3MinDurationTestValue();
		} catch (Exception e) {
		}

		System.out.println("Finished MinDuration - Timertest");
	}

	/**
	 * waiting 10s to test the timer
	 */
	private void timerSensortest() {
		System.out.println("Starting Timer - Test...");

		System.out.println("Starting 10s timer...");
		try {
			Thread.sleep(10000);
			System.out.println("Finished 10s timer");
		} catch (Exception e) {
		}

		System.out.println("Timersensor - Test - Finished");
	}

	/**
	 * Using all tests included in SQLFeatures
	 * 
	 * @throws SQLException
	 */
	private void databaseSensortest() throws SQLException {
		System.out.println("Starting Databasesensor - Test...");

		SQLFeatures sqlFeatures = new SQLFeatures();
		sqlFeatures.preparedStatement(ConnectionFactory.getRandom());
		sqlFeatures.unpreparedStatement(ConnectionFactory.getRandom());
		sqlFeatures.preparedStatementWithBindParameters(ConnectionFactory.getRandom());

		System.out.println("Databasesensor - Test - Finished");
	}

	/**
	 * Testing the exceptionsensor by throwing an empty exception
	 */
	private void exceptionSensortest() {
		System.out.println("Starting Exceptionsensor - Test...");

		System.out.println("Throwing exception...");
		try {
			throw new FakeException();
		} catch (FakeException e) {
			System.out.println("Exception catched...");
		}

		System.out.println("Exceptionsensor - Test - Finished");
	}

	private void plattformSensortest() {
		System.out.println("Starting Plattformsensor - Test...");

		// TODO

		System.out.println("Plattformsensor - Test - Finished");
	}

	/**
	 * Using all tests included in HTTPFeatures
	 * 
	 * @throws ServletException
	 * @throws IOException
	 */
	private void httpSensortest() throws ServletException, IOException {
		System.out.println("Starting HTTPSensor - Test...");

		HttpFeatures httpFeatures = new HttpFeatures();
		httpFeatures.init();
		httpFeatures.httpGetDifferentURLs();
		httpFeatures.httpGetParameters();
		httpFeatures.httpHeadersGet();
		httpFeatures.httpHeadersPost();
		httpFeatures.httpPostDifferentURLs();
		httpFeatures.httpPostParameters();
		httpFeatures.httpSessionParametersGet();
		httpFeatures.httpSessionParametersPost();
		httpFeatures.httpsGetParameters();
		httpFeatures.httpsPostParameters();

		System.out.println("HTTPsensor - Test - Finished");
	}

}
