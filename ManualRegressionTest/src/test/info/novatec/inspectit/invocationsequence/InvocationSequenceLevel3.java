package test.info.novatec.inspectit.invocationsequence;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;

import test.info.novatec.inspectit.http.HttpFeatures;
import test.info.novatec.inspectit.sql.SQLFeatures;
import test.info.novatec.inspectit.sql.tools.ConnectionFactory;

/**
 * Subclass of InvocationSequence calling another Subclass
 * 
 * @author Alfred Kraus
 */
public class InvocationSequenceLevel3 {

	private static boolean testvalue = true;

	public boolean returnTestValue() {
		return testvalue;
	}

	public boolean returnTestValueAfterMinDUration() {
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			System.err.println("Error while waiting 3s");
		}
		return testvalue;
	}

	/**
	 * Pool with tests for sensors with an invocation sequence
	 * 
	 * @throws SQLException
	 * @throws ServletException
	 * @throws IOException
	 */
	public void invocationSequenceSensortestsLevel3() throws SQLException, ServletException, IOException {
		timerSensortest();
		databaseSensortest();
		exceptionSensortest();
		httpSensortest();
	}

	/**
	 * waiting 10s to test the timer
	 */
	private void timerSensortest() {
		try {
			Thread.sleep(4000);
		} catch (Exception e) {
			System.err.println("Error while waiting 4s");
		}
	}

	private void databaseSensortest() throws SQLException {
		SQLFeatures sqlFeatures = new SQLFeatures();
		sqlFeatures.preparedStatement(ConnectionFactory.getRandom());
		sqlFeatures.unpreparedStatement(ConnectionFactory.getRandom());
		sqlFeatures.preparedStatementWithBindParameters(ConnectionFactory.getRandom());
	}

	private void exceptionSensortest() {
		try {
			throw new FakeException();
		} catch (FakeException e) {
			System.out.println("Exception catched...");
		}
	}

	private void httpSensortest() throws ServletException, IOException {
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
	}

	// necessary method
	public void testSteppingFeature() {

	}

	public void testSteppingFeatureSQL() throws SQLException {
		SQLFeatures sqlFeatures = new SQLFeatures();
		sqlFeatures.preparedStatement(ConnectionFactory.getRandom());
		sqlFeatures.unpreparedStatement(ConnectionFactory.getRandom());
		sqlFeatures.preparedStatementWithBindParameters(ConnectionFactory.getRandom());
	}
}
