package test.info.novatec.inspectit.timer;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Providing a timer. Charting is enabled/disabled in Timer.config
 * 
 * @author Alfred Krauss
 *
 */
public class Timer {

	int counter = 1;
	Timer timer;
	
	@BeforeTest
	public void init() {
		timer = new Timer();
	}

	@Test
	public void timerWithoutCharting() {
		fourTimesSleep();
		counter++;
	}
	
	@Test
	public void timerWithCharting() {
		timer.timerWithoutCharting();
		counter++;
	}

	private void fourTimesSleep() {
		// 1st sleep - 1s
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// 2nd sleep - 4s
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// 3rd sleep - 4,5s
		try {
			Thread.sleep(4500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// 4th sleep - 2s
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
