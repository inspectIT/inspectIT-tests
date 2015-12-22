package test.info.novatec.inspectit.logging;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.testng.annotations.Test;

/**
 * Small test class that executes log4j loggings.
 * 
 * @author Stefan Siegl
 */
public class Log4JLoggingFeature {

	/**
	 * Test class to integrate the testee with the testng testing logic.
	 */
	@Test
	public void normalLoggingWithAllSeverities() {
		entryToLog4JLogging();
	}

	/**
	 * Real Testee method.
	 * 
	 * Note that this method will start an invocation sequence containing the
	 * logging features.
	 */
	private void entryToLog4JLogging() {
		Logger logger = Logger.getLogger(Log4JLoggingFeature.class);

		ConsoleAppender console = new ConsoleAppender();
		String PATTERN = "%d [%p|%c|%C{1}] %m%n";
		console.setLayout(new PatternLayout(PATTERN));
		console.setThreshold(Level.ALL);
		console.activateOptions();
		Logger.getRootLogger().addAppender(console);

		logger.log(Level.DEBUG, "Log4J DEBUG message");
		logger.log(Level.INFO, "Log4J INFO message");
		logger.log(Level.WARN, "Log4J WARN message");
		logger.log(Level.FATAL, "Log4J FATAL message");
		logger.log(Level.ERROR, "Log4J ERROR message");
		logger.log(Level.TRACE, "Log4J TRACE message");
	}
}
